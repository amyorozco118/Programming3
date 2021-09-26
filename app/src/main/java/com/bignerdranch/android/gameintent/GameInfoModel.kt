package com.bignerdranch.android.gameintent

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GameInfoModel : ViewModel(){
    val listOfGames = mutableListOf<Game>()
    private val gameRepository = GameRepository.get()
    val gameListLiveData = gameRepository.getGames()

    fun addRandomGame(){
        val game = Game()

        game.teamAScore = Random.nextInt(0,20)
        game.teamBScore = Random.nextInt(0,20)

        listOfGames += game
    }

    fun saveGame(teamAName : String, teamBName : String, teamAScore: Int, teamBScore :Int){
        val game = Game()
        game.teamAName = teamAName
        game.teamBName = teamBName
        game.teamAScore = teamAScore
        game.teamBScore = teamBScore
        listOfGames += game
    }
}