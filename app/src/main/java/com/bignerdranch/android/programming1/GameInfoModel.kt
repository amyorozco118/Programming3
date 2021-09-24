package com.bignerdranch.android.programming1

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GameInfoModel : ViewModel(){
    val listOfGames = mutableListOf<Game>()

    init {

        //upload the data from the dummy DB to the game info model
        for (i in 0 until 100) {
            val game = Game()
            game.index = "Game #$i"

            game.scoreA = Random.nextInt(0,20)
            game.scoreB = Random.nextInt(0,20)

            listOfGames += game
        } }

}