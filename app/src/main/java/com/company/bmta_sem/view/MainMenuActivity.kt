package com.company.bmta_sem.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.company.bmta_sem.R
import com.company.bmta_sem.databinding.ActivityMainMenuBinding
import com.company.bmta_sem.model.GameProvider
import com.company.bmta_sem.viewModel.Game
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader


class MainMenuActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainMenuBinding
    lateinit var game : Game

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
            startActivity(Intent(this, HeroDetailActivity::class.java))
        }
        binding.btnExit.setOnClickListener{
            val startMain = Intent(Intent.ACTION_MAIN)
            startMain.addCategory(Intent.CATEGORY_HOME)
            startActivity(startMain)
        }

        val scenarioJson = readSettingsJson(R.raw.scenarios)
        val heroesJson = readSettingsJson(R.raw.heroes)
        if (GameProvider.game == null) GameProvider.init(scenarioJson,heroesJson)
        game = GameProvider.game!!

        binding.txtHeroName.text = game.currentHero.name

    }

    fun readSettingsJson (resource : Int) : String {
        var string: String? = ""
        val stringBuilder = StringBuilder()
        val inputStream: InputStream = this.resources.openRawResource(resource)
        val reader = BufferedReader(InputStreamReader(inputStream))
        while (true) {
            try {
                if (reader.readLine().also { string = it } == null) break
            } catch (e: IOException) {
                e.printStackTrace()
            }
            stringBuilder.append(string).append("\n")

        }
        inputStream.close()
        return stringBuilder.toString()
    }

}