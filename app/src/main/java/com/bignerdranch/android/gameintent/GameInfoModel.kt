package com.bignerdranch.android.gameintent

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GameInfoModel : ViewModel(){
    val listOfGames = mutableListOf<Game>()
    private val gameRepository = GameRepository.get()
    val gameListLiveData = gameRepository.getGames()

    fun addRandomGame(){
        val game = Game()
        game.index = "0"

        game.scoreA = Random.nextInt(0,20)
        game.scoreB = Random.nextInt(0,20)

        listOfGames += game
    }

    fun saveGame(teamNameA : String, teamNameB : String){
        val game = Game()
        game.index = "Team A: " + teamNameA + " Team B: " + teamNameB
        game.scoreA = Random.nextInt(0,20)
        game.scoreB = Random.nextInt(0,20)

        listOfGames += game

    }
}