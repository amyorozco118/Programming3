package com.bignerdranch.android.gameintent

import androidx.lifecycle.ViewModel
import com.bignerdranch.android.programming1.MainActivity

class GameInfoModel() : ViewModel(){

    val listOfGames = mutableListOf<Game>()
    private val gameRepository = GameRepository.get()
    //we need this to be a variable
    val gameListLiveData = gameRepository.getGames(true)

    fun saveGame(game : Game, teamAName : String, teamBName : String, teamAScore: Int, teamBScore :Int){
        game.teamAName = teamAName
        game.teamBName = teamBName
        game.teamAScore = teamAScore
        game.teamBScore = teamBScore
        listOfGames += game
    }
}