package com.company.bmta_sem.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.company.bmta_sem.R
import com.company.bmta_sem.databinding.ActivityHeroesGalleryBinding

class HeroesGalleryActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHeroesGalleryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = listOf("Hrdina 1", "Hrdina 2", "Hrdina 3")

        binding.heroRowRecycler.layoutManager = LinearLayoutManager(this)
        binding.heroRowRecycler.adapter = LogAdapter(list)
    }
}