package database;
import androidx.lifecycle.LiveData
import androidx.room.Dao;
import androidx.room.Insert
import androidx.room.Query;
import androidx.room.Update

import com.bignerdranch.android.gameintent.Game;

import java.util.List;
import java.util.UUID;

@Dao
interface GameDao {

    @Query("SELECT * FROM game")
    fun getGames(): LiveData<List<Game>>

    @Query("SELECT * FROM game WHERE id=(:id)")
    fun getGame(id: UUID): LiveData<Game?>

    @Update
    fun updateGame(game: Game)

    @Insert
    fun addGame(game: Game)
}


