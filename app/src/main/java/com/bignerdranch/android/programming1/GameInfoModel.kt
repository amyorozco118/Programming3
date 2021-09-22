package com.bignerdranch.android.programming1

import androidx.lifecycle.ViewModel

class GameInfoModel : ViewModel(){
    val listOfGames = mutableListOf<Game>()
    init {
        for (i in 0 until 100) {
            val game = Game()
            game.index = "Game #$i"
            game.scoreA = 2
            game.scoreB = 1
            listOfGames += game
        } }

}