package com.company.bmta_sem.view

import Model.Hero
import Model.JsonConverter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.company.bmta_sem.R
import com.company.bmta_sem.databinding.ActivityMainMenuBinding
import com.company.bmta_sem.databinding.ActivityNewHeroBinding
import com.company.bmta_sem.model.GameProvider

class NewHeroActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNewHeroBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNewHeroConfirm.setOnClickListener{
            var name = binding.etxtNewHeroName.text.toString()
            var des = binding.etxtNewHeroDescription.text.toString()
            if(name != null || name != ""){
                var heroes = JsonConverter.realHeroes;
                var realHeroes : ArrayList<Hero> = arrayListOf()
                for (hero in heroes!!){
                    realHeroes.add(hero)
                }
                if (des == null || des == "") des = "No description."
                realHeroes.add(Hero(name,des,100.0,2.0,1.0))
                JsonConverter.realHeroes = realHeroes
                GameProvider.game!!.refresh = true
                JsonConverter.saveHeroes(this)
                this.startActivity(Intent(this,MainMenuActivity::class.java))
            }else{
                Toast.makeText(this, "Name was left empty.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}