package com.bignerdranch.android.gameintent

import android.content.Context;
import androidx.lifecycle.LiveData
import androidx.room.Room
import database.GameDatabase
import java.io.File
import java.util.*
import java.util.concurrent.Executors

private const val DATABASE_NAME = "game-database"

class GameRepository  private constructor(context:Context) {

    private val database : GameDatabase = Room.databaseBuilder(
        context.applicationContext,
        GameDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val executor = Executors.newSingleThreadExecutor()
    private val gameDao = database.gameDao()
    private val filesDir = context.applicationContext.filesDir

    fun getPhotoFileA(game: Game): File = File(filesDir, game.photoFileName)
    fun getPhotoFileB(game: Game): File = File(filesDir, game.photoFileName)

    fun getGames(isTeamAWinning: Boolean): LiveData<List<Game>> = gameDao.getGames(isTeamAWinning)
    fun getGame(id: UUID): LiveData<Game?> = gameDao.getGame(id)

    fun updateGame(game: Game) {
        executor.execute {
            gameDao.updateGame(game)
        }
    }
    fun addGame(game: Game) {
        executor.execute {
            gameDao.addGame(game)
        }
    }

    companion object {
        private var INSTANCE:GameRepository ? = null
        fun initialize (context:Context){
            if (INSTANCE == null) {
                INSTANCE = GameRepository(context)
            }
        }
        fun get():GameRepository {
            return INSTANCE ?:
            throw IllegalStateException("GameRepository must be initialized")
        }
    }

}