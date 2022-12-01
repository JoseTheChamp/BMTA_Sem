package com.company.bmta_sem.viewModel

import Model.*
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.company.bmta_sem.model.Event
import com.company.bmta_sem.view.*

class Game(
    scenarioJson: String = "",
    heroesJson: String = ""
) : ViewModel() {
    var scenarios : List<Scenario> = listOf()
    open var heroes : List<Hero> = listOf()
    lateinit var currentScenario : Scenario
    lateinit var currentHero : Hero
    lateinit var currentEvent : Event
    var refresh : Boolean = false
    init {
        JsonConverter.initial(scenarioJson,heroesJson)
        scenarios = JsonConverter.getScenarios()
        heroes = JsonConverter.getHeroes()
        currentHero = heroes[0]
    }

    fun StartScenario(context: Context,index: Int){
        println("IN GAME - START SCENARIO")
        currentScenario = scenarios[index]
        var intent = Intent(context, StoryEventActivity::class.java)
        currentEvent = currentScenario.events[0]
        context.startActivity(intent)
    }
    fun StartEvent(context: Context,targetId : Int){
        if (targetId < 0){
            if (targetId == -1) {
                context.startActivity(Intent(context,MainMenuActivity::class.java))
                return
            }
            throw Exception("Zaporny cislo eventu")
        }else{
            for (event in currentScenario.events){
                println("ID hledani: " + event.id.toString() + "    hledam " + targetId)
                if (event.id == targetId) {
                    currentEvent = event
                    var intent: Intent?
                    when(currentEvent) {
                        is StoryEvent -> intent = Intent(context, StoryEventActivity::class.java)
                        is ChallengeEvent -> intent = Intent(context, ChallengeEventActivity::class.java)
                        is FightEvent -> intent = Intent(context, FightEventActivity::class.java)
                        is EndEvent -> intent = Intent(context, EndEventActivity::class.java)
                        is StatsEvent -> intent = Intent(context, StoryEventActivity::class.java)
                        else -> throw Exception("This type of event does not exist (game-start event)")
                    }
                    context.startActivity(intent)
                    return
                }
            }
            throw Exception("Event id does not exist: " + targetId.toString())
        }
    }

    fun toasti(context: Context){
        val toast: Toast = Toast.makeText(context, "Pokussssss", Toast.LENGTH_LONG)
        var intent = Intent(context, HeroesGalleryActivity::class.java)
        context.startActivity(intent)
        toast.show()
    }
}