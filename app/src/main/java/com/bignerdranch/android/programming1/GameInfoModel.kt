package com.bignerdranch.android.programming1

import androidx.lifecycle.ViewModel

class GameInfoModel : ViewModel(){
    val listOfGames = mutableListOf<Game>()
    init {
        for (i in 0 until 100) {
            val game = Game()
            game.index = "Crime #$i"
            listOfGames += game
        } }

}