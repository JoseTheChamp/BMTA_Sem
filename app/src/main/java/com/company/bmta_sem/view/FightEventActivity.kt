package com.company.bmta_sem.view

import Model.FightEvent
import android.os.Bundle
import android.widget.TextView
import com.company.bmta_sem.databinding.ActivityFightEventBinding
import com.company.bmta_sem.model.GameProvider

class FightEventActivity : EventActivity() {
    private lateinit var binding : ActivityFightEventBinding
    lateinit var event: FightEvent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFightEventBinding.inflate(layoutInflater)
        setContentView(binding.root)
        game = GameProvider.game
        hero = game.currentHero
        event = game.currentEvent as FightEvent

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
        var enemy = TextView(this)
        enemy.text = event.enemy.name + "\n" + event.enemy.description +
                "\nHeatlh: " + event.enemy.health + "  Attack: " + event.enemy.attack +
                "  Armor: " + event.enemy.armor
        enemy.textSize = 16f
        binding.layoutContent.addView(enemy)
    }

    override fun setOptions() {
        var options = event.getAllEventoptions()
        var possible = event.getEventOptionsPossible(hero)
        for (i in options.indices step 1){
            binding.layoutButtons.addView(createoptionButton(options[i],possible[i],game,options.size))
        }
    }

}