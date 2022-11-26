package com.company.bmta_sem.view

import Model.Event
import Model.Hero
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.company.bmta_sem.databinding.ActivityScenarioGalleryBinding
import com.company.bmta_sem.databinding.ActivityStoryEventBinding
import com.company.bmta_sem.viewModel.Game
import com.company.bmta_sem.viewModel.GameProvider

class StoryEventActivity(override var event: Event) : EventActivity(event) {
    private lateinit var binding : ActivityStoryEventBinding
    private lateinit var game: Game
    private lateinit var hero: Hero

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoryEventBinding.inflate(layoutInflater)
        setContentView(binding.root)
        game = GameProvider.game
        hero = game.currentHero
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
            binding.layoutButtons.addView(createoptionButton(options[i],possible[i],game))
        }
    }
}