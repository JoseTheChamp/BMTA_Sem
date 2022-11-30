package com.company.bmta_sem.model

import com.company.bmta_sem.viewModel.Game

class GameProvider() {
    companion object {
        lateinit var game : Game

        fun init(json : String){
            game = Game(json)
        }
    }
}