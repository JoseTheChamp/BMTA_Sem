package com.company.bmta_sem.view

import Model.EndEvent
import Model.JsonConverter
import android.os.Bundle
import android.widget.TextView
import com.company.bmta_sem.databinding.ActivityEndEventBinding
import com.company.bmta_sem.model.GameProvider

class EndEventActivity : EventActivity() {
    private lateinit var binding : ActivityEndEventBinding
    lateinit var event: EndEvent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEndEventBinding.inflate(layoutInflater)
        setContentView(binding.root)
        game = GameProvider?.game!!
        hero = game.currentHero
        event = game.currentEvent as EndEvent

        setNameStory()
        setContent()
        setOptions()
        game.refresh = true
        JsonConverter.saveHeroes(this)
    }

    override fun setNameStory() {
        binding.txtEventName.text = event.name
        binding.txtScenarioName.text = game.currentScenario.name
        binding.txtStory.text = event.story
    }

    override fun setContent() {
        var prompt = TextView(this)
        prompt.text = "End of an Adventure."
        prompt.textSize = 18f
        binding.layoutContent.addView(prompt)
    }

    override fun setOptions() {
        var options = event.getAllEventoptions()
        var possible = event.getEventOptionsPossible(hero)
        for (i in options.indices step 1){
            binding.layoutButtons.addView(createoptionButton(options[i],possible[i],game,options.size))
        }
    }
}