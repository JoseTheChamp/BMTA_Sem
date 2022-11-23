package Model

import android.util.Log
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class ScenarioJson (var dataJson : String) {
    var scenarios : JSONArray? = null
    var heroes : JSONArray? = null
    init {
        scenarios = parseJsonArray("scenarios")
        heroes = parseJsonArray("heroes")
    }

    fun getHeroes() : List<Hero>{
        //read all heroes
        return listOf()
    }

    fun getScenarios() : List<Scenario>{
        var len = 0
        var realScenarios : ArrayList<Scenario> = ArrayList()
        len = scenarios?.length()!!
        for (i in 0..len step 1){
            realScenarios.add(readScenario(scenarios!!.getJSONObject(i))!!)
        }
        return realScenarios
    }

    fun readScenario(jo: JSONObject) : Scenario?{
        var name = jo.getString("name")
        var events = arrayListOf<Event>()
        var len = jo.getJSONArray("events").length()
        for (i in 0..len step 1){
            events.add(readEvent(jo.getJSONArray("events").getJSONObject(i))!!)
        }
        var scenario = Scenario(name,events)
        return scenario
    }

    fun readEvent(jo: JSONObject) : Event? {
        //read name ....... all options
        return null
    }

    fun readOption(jo: JSONObject) : EventOption? {

        return null
    }

    fun readHero(jo: JSONObject) : Hero? {

        return null
    }

    fun readStatValue(jo: JSONObject) : StatValue? {

        return null
    }

    fun readEnemy(jo : JSONObject) : Enemy? {

        return null
    }

    fun parseJsonString(item:String) : String? {
        try {
            val jObj = JSONObject(dataJson)
            return jObj.getString(item)
        } catch (ex: JSONException) {
            Log.i("JsonParser String", "unexpected JSON exception", ex)
            return null
        }
    }

    fun parseJsonObject(item:String) : JSONObject? {
        try {
            val jObj = JSONObject(dataJson)
            return jObj.getJSONObject(item)
        } catch (ex: JSONException) {
            Log.i("JsonParser object", "unexpected JSON exception", ex)
            return null
        }
    }

    fun parseJsonArray(item:String) : JSONArray? {
        try {
            val jObj = JSONObject(dataJson)
            return jObj.getJSONArray(item)
        } catch (ex: JSONException) {
            Log.i("JsonParser array", "unexpected JSON exception", ex)
            return null
        }
    }


}