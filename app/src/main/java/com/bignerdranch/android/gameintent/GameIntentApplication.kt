package com.bignerdranch.android.gameintent
import android.app.Application

class GameIntentApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        GameRepository.initialize(this)
    }
}