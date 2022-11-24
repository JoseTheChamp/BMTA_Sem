package com.company.bmta_sem.viewModel

import Model.Hero
import Model.Scenario
import Model.JsonConverter
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.company.bmta_sem.R
import com.company.bmta_sem.view.HeroesGalleryActivity
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class Game(
    dataJson: String = ""
) : ViewModel() {
    var scenarios : List<Scenario> = listOf()
    var heroes : List<Hero> = listOf()

    init {
        val jsonConverter = JsonConverter(dataJson)
        scenarios = jsonConverter.getScenarios()
        heroes = jsonConverter.getHeroes()
    }

    fun StartScenario(index: Int){
        println("AAAAAAAAAAAAAA - spust " + index.toString())
        println(scenarios[index].name)
        //startActivity(Intent(context, HeroesGalleryActivity::class.java))
    }



}