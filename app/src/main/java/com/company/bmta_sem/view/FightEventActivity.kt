package com.company.bmta_sem.view

import Model.Enemy
import Model.FightEvent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.company.bmta_sem.databinding.ActivityFightEventBinding
import com.company.bmta_sem.model.GameProvider

class FightEventActivity : EventActivity() {
    private lateinit var binding : ActivityFightEventBinding
    lateinit var event: FightEvent
    var realHealth : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFightEventBinding.inflate(layoutInflater)
        setContentView(binding.root)
        game = GameProvider?.game!!
        hero = game.currentHero
        event = game.currentEvent as FightEvent
        setNameStory()
        realHealth = event.enemy.health
        setOptions()
        setContent()
    }

    override fun setNameStory() {
        binding.txtEventName.text = event.name
        binding.txtScenarioName.text = game.currentScenario.name
        binding.txtStory.text = event.story
    }

    override fun setContent() {
        var layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        var enemy = TextView(this)
        enemy.text = event.enemy.name + "\n" + event.enemy.description +
                "\nHeatlh: " + realHealth + "  Attack: " + event.enemy.attack +
                "  Armor: " + event.enemy.armor
        enemy.textSize = 16f
        var result = TextView(this)
        result.text = "You've defeated the " + event.enemy.name + ".\nYou are left with " + hero.health + " health."
        result.textSize = 16f
        layout.addView(enemy)
        layout.addView(result)
        binding.layoutContent.addView(layout)
    }

    override fun setOptions() {
        var options = event.getAllEventoptions()
        var possible = event.getEventOptionsPossible(hero)
        for (i in options.indices step 1){
            binding.layoutButtons.addView(createoptionButton(options[i],possible[i],game,options.size))
        }
    }

}