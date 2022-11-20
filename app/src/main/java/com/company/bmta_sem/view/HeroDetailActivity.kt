package com.company.bmta_sem.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.company.bmta_sem.R
import com.company.bmta_sem.databinding.ActivityHeroDetailBinding
import com.company.bmta_sem.databinding.ActivityHeroesGalleryBinding

class HeroDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHeroDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}