package database;
import androidx.lifecycle.LiveData
import androidx.room.Dao;
import androidx.room.Insert
import androidx.room.Query;
import androidx.room.Update

import com.bignerdranch.android.gameintent.Game;

import java.util.UUID;

@Dao
interface GameDao {

    @Query("SELECT * FROM table_game where (teamAScore > teamBScore) = (:isTeamAWinning)")
    fun getGames(isTeamAWinning : Boolean): LiveData<List<Game>>

    @Query("SELECT * FROM table_game WHERE id=(:id)")
    fun getGame(id: UUID): LiveData<Game?>

    @Update
    fun updateGame(game: Game)

    @Insert
    fun addGame(game: Game)
}


