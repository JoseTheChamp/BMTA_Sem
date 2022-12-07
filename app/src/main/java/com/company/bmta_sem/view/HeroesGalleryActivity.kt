package com.company.bmta_sem.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.company.bmta_sem.databinding.ActivityHeroesGalleryBinding
import com.company.bmta_sem.model.GameProvider

class HeroesGalleryActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHeroesGalleryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list : ArrayList<String> = ArrayList()
        var game = GameProvider.game
        for (hero in game?.heroes!!){
          list.add(hero.name)
        }

        binding.btnNewHero.setOnClickListener{
            startActivity(Intent(this, NewHeroActivity::class.java))
        }

        binding.heroRowRecycler.layoutManager = LinearLayoutManager(this)
        var heroAdapter = RowHeroAdapter(list)
        heroAdapter.context = this
        binding.heroRowRecycler.adapter = heroAdapter
    }
}