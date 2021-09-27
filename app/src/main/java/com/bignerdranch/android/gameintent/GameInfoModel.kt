package com.bignerdranch.android.gameintent

import androidx.lifecycle.ViewModel

class GameInfoModel() : ViewModel(){

    var isTeamAWinning = true

    val listOfGames = mutableListOf<Game>()
    private val gameRepository = GameRepository.get()
    //!!!we need this to be a variable
    fun gameListLiveData() = gameRepository.getGames(isTeamAWinning)

    fun saveGame(game : Game, teamAName : String, teamBName : String, teamAScore: Int, teamBScore :Int){
        game.teamAName = teamAName
        game.teamBName = teamBName
        game.teamAScore = teamAScore
        game.teamBScore = teamBScore
        listOfGames += game
    }
}