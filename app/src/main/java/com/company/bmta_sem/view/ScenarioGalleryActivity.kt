package com.company.bmta_sem.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.company.bmta_sem.databinding.ActivityScenarioGalleryBinding
import com.company.bmta_sem.viewModel.Game
import com.company.bmta_sem.model.GameProvider

class ScenarioGalleryActivity : AppCompatActivity() {
    private lateinit var binding : ActivityScenarioGalleryBinding
    lateinit var game : Game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScenarioGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        game = GameProvider.game

        val scenarios = game.scenarios
        val list : ArrayList<String> = arrayListOf()
        for (scenario in scenarios){
            list.add(scenario.name)
        }

        binding.scenarioRowRecycler.layoutManager = LinearLayoutManager(this)
        binding.scenarioRowRecycler.adapter = LogAdapter(list)
    }
}