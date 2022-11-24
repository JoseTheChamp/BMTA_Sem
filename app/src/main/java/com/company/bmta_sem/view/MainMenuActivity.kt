package com.company.bmta_sem.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.company.bmta_sem.R
import com.company.bmta_sem.databinding.ActivityMainMenuBinding
import com.company.bmta_sem.viewModel.Game
import com.company.bmta_sem.viewModel.GameProvider
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
            startActivity(Intent(this, ScenarioGalleryActivity::class.java))
        }
        binding.btnExit.setOnClickListener{
            System.exit(0);
        }

        val dataJson = readSettingsJson()
        GameProvider.init(dataJson)
        game = GameProvider.game
        /*
        val factory = GameFactory(dataJson)
        game = ViewModelProvider(this, factory).get(Game::class.java)

        var game2 = ViewModelProvider(this).get(Game::class.java)
        */
        var text = game.scenarios[0].events[0].name
        val toast: Toast = Toast.makeText(applicationContext, text + "2", Toast.LENGTH_LONG)
        toast.show()

    }

    fun readSettingsJson () : String {
        var string: String? = ""
        val stringBuilder = StringBuilder()
        val inputStream: InputStream = this.resources.openRawResource(R.raw.data)
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