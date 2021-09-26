package com.bignerdranch.android.gameintent

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Game(@PrimaryKey val id: UUID = UUID.randomUUID(),
                var teamA: String = "",
                var teamB: String = "",
                var date: Date = Date(),
                var scoreA: Int = 0,
                var scoreB: Int = 0,
                var index: String = ""

)
