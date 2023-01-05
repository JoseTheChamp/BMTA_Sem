package com.company.bmta_sem.model

import com.company.bmta_sem.viewModel.Game

class GameProvider() {
    companion object {
        open var game: Game? = null

        fun setHealth(value: Double) {
            game?.currentHero?.health = value
        }

        fun init(scenarioJson: String, heroesJson: String) {
            game = Game(scenarioJson, heroesJson)
        }
    }
}