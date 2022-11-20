package com.company.bmta_sem.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.company.bmta_sem.R
import com.company.bmta_sem.databinding.ActivityHeroesGalleryBinding
import com.company.bmta_sem.databinding.ActivityMainMenuBinding

class MainMenuActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnHeroes.setOnClickListener{
            startActivity(Intent(this, HeroesGalleryActivity::class.java))
        }
        binding.btnPlayScenario.setOnClickListener{
            startActivity(Intent(this, ScenarioGalleryActivity::class.java))
        }
        binding.btnHeroDetail.setOnClickListener{
            startActivity(Intent(this, ScenarioGalleryActivity::class.java))
        }
        binding.btnExit.setOnClickListener{
            System.exit(0);
        }

    }
}