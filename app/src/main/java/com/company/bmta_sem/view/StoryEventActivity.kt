package com.company.bmta_sem.view

import Model.StoryEvent
import android.os.Bundle
import com.company.bmta_sem.databinding.ActivityStoryEventBinding
import com.company.bmta_sem.model.GameProvider

class StoryEventActivity() : EventActivity() {
    private lateinit var binding : ActivityStoryEventBinding
    lateinit var event: StoryEvent

    override fun onCreate(savedInstanceState: Bundle?) {
        println("IN CREATE OF STORY")
        super.onCreate(savedInstanceState)
        binding = ActivityStoryEventBinding.inflate(layoutInflater)
        setContentView(binding.root)
        game = GameProvider.game
        hero = game.currentHero
        event = game.currentEvent as StoryEvent

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

    }

    override fun setOptions() {
        var options = event.getAllEventoptions()
        var possible = event.getEventOptionsPossible(hero)
        for (i in options.indices step 1){
            binding.layoutButtons.addView(createoptionButton(options[i],possible[i],game,options.size))
        }
    }
}