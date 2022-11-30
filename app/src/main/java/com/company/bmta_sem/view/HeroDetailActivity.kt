package com.company.bmta_sem.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.company.bmta_sem.R
import com.company.bmta_sem.databinding.ActivityHeroDetailBinding
import com.company.bmta_sem.databinding.ActivityHeroesGalleryBinding
import com.company.bmta_sem.model.GameProvider

class HeroDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHeroDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var hero = GameProvider.game?.currentHero!!

        binding.txtHeroDetailName.text = hero.name
        binding.txtDes.text = hero.description

        binding.txtCha.text = hero.charisma.toString()
        binding.txtDex.text = hero.dexterity.toString()
        binding.txtCon.text = hero.constitution.toString()
        binding.txtInt.text = hero.inteligence.toString()
        binding.txtWis.text = hero.wisdom.toString()
        binding.txtStr.text = hero.strength.toString()
    }
}