package com.company.bmta_sem.viewModel

import Model.Hero
import Model.Scenario
import Model.JsonConverter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.company.bmta_sem.R
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class GameFactory (
    private val dataJson : String
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(Game::class.java)) {
            return Game(dataJson) as T
        }
        throw IllegalArgumentException("Unknown Viewmodel class")
    }
}

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









}