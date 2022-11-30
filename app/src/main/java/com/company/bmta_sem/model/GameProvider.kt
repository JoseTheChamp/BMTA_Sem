package com.company.bmta_sem.model

import com.company.bmta_sem.viewModel.Game

class GameProvider() {
    companion object {
        var game : Game? = null

        fun init(json : String){
            game = Game(json)
        }
    }
}