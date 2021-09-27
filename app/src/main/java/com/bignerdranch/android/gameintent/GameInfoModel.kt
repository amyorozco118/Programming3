package com.bignerdranch.android.gameintent

import androidx.lifecycle.ViewModel
import java.util.*

class GameInfoModel : ViewModel(){

    val listOfGames = mutableListOf<Game>()
    private val gameRepository = GameRepository.get()
    val gameListLiveData = gameRepository.getGames()

    fun saveGame(game : Game, teamAName : String, teamBName : String, teamAScore: Int, teamBScore :Int){
        game.teamAName = teamAName
        game.teamBName = teamBName
        game.teamAScore = teamAScore
        game.teamBScore = teamBScore
        listOfGames += game
    }
}