package Model

import android.content.Context
import android.net.Uri
import android.util.JsonWriter
import android.util.Log
import com.company.bmta_sem.R
import com.company.bmta_sem.model.Event
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.io.OutputStreamWriter

class JsonConverter() {
    companion object {
        var scenarios: JSONArray? = null
        var heroes: JSONArray? = null
        var realHeroes: List<Hero>? = null
        var heroesPath: String? = null

        init {

        }

        fun initial(scenarioJson: String, heroesjson: String) {
            scenarios = parseJsonArray("scenarios", scenarioJson)
            heroes = parseJsonArray("heroes", heroesjson)
            realHeroes = getHeroes()
        }

        fun saveHeroes(context: Context) {
            val inputStream = context.resources.openRawResource(R.raw.heroes)
            val uri = Uri.parse("android.resource://raw/heroes")
            //val file = File(uri.path)
            var file = File(context.filesDir.toString() + "/heroes.json")
            println("----------------------------")
            println(file.absoluteFile)
            var outstr = FileOutputStream(file)
            writeJsonStream(outstr, realHeroes!!)
        }

        fun writeJsonStream(out: OutputStream, heroes: List<Hero>) {
            var jsonWriter = JsonWriter(OutputStreamWriter(out, "UTF-8"))
            jsonWriter.setIndent("  ")
            writeHeroesArray(jsonWriter, heroes)
            jsonWriter.close()
        }

        fun writeHeroesArray(writer: JsonWriter, heroes: List<Hero>) {
            writer.beginObject()
            writer.name("heroes")
            writer.beginArray()
            for (hero in heroes) {
                writeHero(writer, hero)
            }
            writer.endArray()
            writer.endObject()
        }

        fun writeHero(writer: JsonWriter, hero: Hero) {
            writer.beginObject()
            writer.name("name").value(hero.name)
            writer.name("description").value(hero.description)
            writer.name("health").value(hero.health)
            writer.name("attack").value(hero.attack)
            writer.name("armor").value(hero.armor)
            writer.name("strength").value(hero.strength)
            writer.name("dexterity").value(hero.dexterity)
            writer.name("constitution").value(hero.constitution)
            writer.name("inteligence").value(hero.inteligence)
            writer.name("wisdom").value(hero.wisdom)
            writer.name("charisma").value(hero.charisma)
            writer.endObject()
        }

        fun getHeroes(): List<Hero> {
            var len = 0
            var realHeroes: ArrayList<Hero> = ArrayList()
            len = heroes?.length()!!
            for (i in 0 until len step 1) {
                realHeroes.add(readHero(heroes!!.getJSONObject(i))!!)
            }
            return realHeroes
        }

        fun getScenarios(): List<Scenario> {
            var len = 0
            var realScenarios: ArrayList<Scenario> = ArrayList()
            len = scenarios?.length()!!
            for (i in 0 until len step 1) {
                realScenarios.add(readScenario(scenarios!!.getJSONObject(i))!!)
            }
            return realScenarios
        }

        fun readScenario(jo: JSONObject): Scenario {
            var name = jo.getString("name")
            var events = arrayListOf<Event>()
            var len = jo.getJSONArray("events").length()
            for (i in 0 until len step 1) {
                events.add(readEvent(jo.getJSONArray("events").getJSONObject(i))!!)
            }
            var scenario = Scenario(name, events)
            return scenario
        }

        fun readEvent(jo: JSONObject): Event {
            var type = jo.getString("type")
            var name = jo.getString("name")
            var story = jo.getString("story")
            var id = jo.getInt("id")
            when (type) {
                "Story" -> {
                    var options: ArrayList<EventOption> = arrayListOf()
                    var len = jo.getJSONArray("options").length()
                    for (i in 0 until len step 1) {
                        options.add(readOption(jo.getJSONArray("options").getJSONObject(i)))
                    }
                    return StoryEvent(id, name, story, options)
                }
                "Fight" -> {
                    var enemy = readEnemy(jo.getJSONObject("enemy"))
                    var optionPassed = readOption(jo.getJSONObject("optionPassed"))
                    var optionFailed = readOption(jo.getJSONObject("optionFailed"))
                    return FightEvent(id, name, story, enemy, optionPassed, optionFailed)
                }
                "Challenge" -> {
                    var optionPassed = readOption(jo.getJSONObject("optionPassed"))
                    var optionFailed = readOption(jo.getJSONObject("optionFailed"))
                    var stat = readStatValue(jo.getJSONObject("stat"))
                    return ChallengeEvent(id, name, story, optionPassed, optionFailed, stat)
                }
                "End" -> {
                    var option = readOption(jo.getJSONObject("option"))
                    return EndEvent(id, name, story, option)
                }
                "Stat" -> {
                    var stats: ArrayList<StatValue> = arrayListOf()
                    var option = readOption(jo.getJSONObject("option"))
                    var len = jo.getJSONArray("stats").length()
                    for (i in 0 until len step 1) {
                        stats.add(readStatValue(jo.getJSONArray("stats").getJSONObject(i)))
                        //stats.add(readOption(jo.getJSONArray("stats").getJSONObject(i)))
                    }
                    return StatsEvent(id, name, story, option, stats)
                }
            }
            throw Exception("ERROR - my")
        }

        fun readOption(jo: JSONObject): EventOption {
            var targetId = jo.getInt("targetId")
            var name = jo.getString("name")
            var hint = jo.getString("hint")
            var joStat: JSONObject? =
                jo.optJSONObject("stat") ?: return EventOption(targetId, name, hint)
            var stat = readStatValue(joStat!!)
            return EventOption(targetId, name, hint, stat)
        }

        fun readHero(jo: JSONObject): Hero {
            var name = jo.getString("name")
            var description = jo.getString("description")
            var health = jo.optDouble("health", 100.0)
            var attack = jo.optDouble("attack", 3.0)
            var armor = jo.optDouble("armor", 0.0)
            var dexterity = jo.optDouble("dexterity", 1.0)
            var strength = jo.optDouble("strength", 1.0)
            var wisdom = jo.optDouble("wisdom", 1.0)
            var inteligence = jo.optDouble("inteligence", 1.0)
            var charisma = jo.optDouble("charisma", 1.0)
            var constitution = jo.optDouble("constitution", 1.0)
            return Hero(
                name,
                description,
                health,
                attack,
                armor,
                strength,
                wisdom,
                inteligence,
                charisma,
                constitution,
                dexterity
            )
        }

        fun readStatValue(jo: JSONObject): StatValue {
            var stat = jo.getString("stat")
            var value = jo.getDouble("value")
            when (stat) {
                "Dexterity" -> return StatValue(Stat.DEXTERITY, value)
                "Inteligence" -> return StatValue(Stat.INTELIGENCE, value)
                "Charisma" -> return StatValue(Stat.CHARISMA, value)
                "Constitution" -> return StatValue(Stat.CONSTITUTION, value)
                "Wisdom" -> return StatValue(Stat.WISDOM, value)
                "Strength" -> return StatValue(Stat.STRENGTH, value)
            }
            throw Exception("ERROR - my")
        }

        fun readEnemy(jo: JSONObject): Enemy {
            var name = jo.getString("name")
            var description = jo.getString("description")
            var health = jo.getDouble("health")
            var attack = jo.getDouble("attack")
            var armor = jo.getDouble("armor")
            return Enemy(name, description, health, attack, armor)
        }

        fun parseJsonArray(item: String, scope: String): JSONArray? {
            try {
                val jObj = JSONObject(scope)
                return jObj.getJSONArray(item)
            } catch (ex: JSONException) {
                Log.i("JsonParser array", "unexpected JSON exception", ex)
                return null
            }
        }
    }
}