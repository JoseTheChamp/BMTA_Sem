package com.company.bmta_sem.view

import Model.Stat
import Model.StatsEvent
import android.os.Bundle
import android.widget.TextView
import com.company.bmta_sem.databinding.ActivityStatsEventBinding
import com.company.bmta_sem.model.GameProvider

class StatsEventActivity : EventActivity() {
    private lateinit var binding : ActivityStatsEventBinding
    lateinit var event: StatsEvent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStatsEventBinding.inflate(layoutInflater)
        setContentView(binding.root)
        game = GameProvider.game
        hero = game.currentHero
        event = game.currentEvent as StatsEvent

        event.run(hero)

        setNameStory()
        setContent()
        setOptions()
    }

    override fun setNameStory() {
        binding.txtEventName.text = event.name
        binding.txtScenarioName.text = game.currentScenario.name
        binding.txtStory.text = event.story
    }

    override fun setContent() {
        var stats = TextView(this)
        var value1 : Double
        var value2 : Double
        var rozdil : Double
        stats.text = ""
        for (stat in event.stats){
            when(stat.stat){
                Stat.STRENGTH -> {
                    value1 = hero.strength - stat.value
                    value2 = hero.strength
                }
                Stat.DEXTERITY -> {
                    value1 = hero.dexterity - stat.value
                    value2 = hero.dexterity
                }
                Stat.INTELIGENCE -> {
                    value1 = hero.inteligence - stat.value
                    value2 = hero.inteligence
                }
                Stat.CHARISMA -> {
                    value1 = hero.charisma - stat.value
                    value2 = hero.charisma
                }
                Stat.WISDOM -> {
                    value1 = hero.wisdom - stat.value
                        value2 = hero.wisdom
                }
                Stat.CONSTITUTION -> {
                    value1 = hero.constitution - stat.value
                    value2 = hero.constitution
                }
                Stat.ARMOR -> {
                    value1 = hero.armor - stat.value
                    value2 = hero.armor
                }
                Stat.HEALTH -> {
                    value1 = hero.health - stat.value
                    value2 = hero.health
                }
                Stat.ATTACK -> {
                    value1 = hero.attack - stat.value
                    value2 = hero.attack
                }
            }
            stats.text = stats.text.toString() + ":  " + value1 + " -> " + value2 + " (" + stat.value + ")\n"
        }
        stats.textSize = 16f
        binding.layoutContent.addView(stats)
    }

    override fun setOptions() {
        var options = event.getAllEventoptions()
        var possible = event.getEventOptionsPossible(hero)
        for (i in options.indices step 1){
            binding.layoutButtons.addView(createoptionButton(options[i],possible[i],game,options.size))
        }
    }
}