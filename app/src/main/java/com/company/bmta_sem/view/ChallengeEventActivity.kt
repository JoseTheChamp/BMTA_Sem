package com.company.bmta_sem.view

import Model.ChallengeEvent
import Model.Stat
import android.os.Bundle
import android.widget.TextView
import com.company.bmta_sem.databinding.ActivityChallengeEventBinding
import com.company.bmta_sem.model.GameProvider

class ChallengeEventActivity : EventActivity() {
    private lateinit var binding : ActivityChallengeEventBinding
    lateinit var event: ChallengeEvent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChallengeEventBinding.inflate(layoutInflater)
        setContentView(binding.root)
        game = GameProvider.game
        hero = game.currentHero
        event = game.currentEvent as ChallengeEvent

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
        var chal = TextView(this)
        var cislo1 : Double = 0.0
        var prompt: String = "failed"
        when(event.stat.stat){
            Stat.STRENGTH -> {
                cislo1 = hero.strength
                if (cislo1 > event.stat.value) prompt = "won"
            }
            Stat.DEXTERITY -> {
                cislo1 = hero.dexterity
                if (cislo1 > event.stat.value) prompt = "won"
            }
            Stat.INTELIGENCE -> {
                cislo1 = hero.inteligence
                if (cislo1 > event.stat.value) prompt = "won"
            }
            Stat.CHARISMA -> {
                cislo1 = hero.charisma
                if (cislo1 > event.stat.value) prompt = "won"
            }
            Stat.WISDOM -> {
                cislo1 = hero.wisdom
                if (cislo1 > event.stat.value) prompt = "won"
            }
            Stat.CONSTITUTION -> {
                cislo1 = hero.constitution
                if (cislo1 > event.stat.value) prompt = "won"
            }
            Stat.ARMOR -> {
                cislo1 = hero.armor
                if (cislo1 > event.stat.value) prompt = "won"
            }
            Stat.HEALTH -> {
                cislo1 = hero.health
                if (cislo1 > event.stat.value) prompt = "won"
            }
            Stat.ATTACK -> {
                cislo1 = hero.attack
                if (cislo1 > event.stat.value) prompt = "won"
            }
        }
        chal.text = "Challenge: " + event.stat.stat + " " + event.stat.value + "\n" +
                hero.name + ": " + event.stat.stat + " " + cislo1 + "\n" +
                "Vysledek: " + prompt
        chal.textSize = 16f
        binding.layoutContent.addView(chal)
    }

    override fun setOptions() {
        var options = event.getAllEventoptions()
        var possible = event.getEventOptionsPossible(hero)
        for (i in options.indices step 1){
            binding.layoutButtons.addView(createoptionButton(options[i],possible[i],game,options.size))
        }
    }

}