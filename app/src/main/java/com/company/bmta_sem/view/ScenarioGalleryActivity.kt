package com.company.bmta_sem.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.company.bmta_sem.databinding.ActivityHeroesGalleryBinding
import com.company.bmta_sem.databinding.ActivityScenarioGalleryBinding

class ScenarioGalleryActivity : AppCompatActivity() {
    private lateinit var binding : ActivityScenarioGalleryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScenarioGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = listOf("Scenario 1", "Scenario 2", "Scenario 3")

        binding.scenarioRowRecycler.layoutManager = LinearLayoutManager(this)
        binding.scenarioRowRecycler.adapter = LogAdapter(list)
    }
}