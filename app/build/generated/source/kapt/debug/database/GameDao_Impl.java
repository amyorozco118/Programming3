package database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bignerdranch.android.gameintent.Game;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GameDao_Impl implements GameDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Game> __insertionAdapterOfGame;

  private final GameTypeConverters __gameTypeConverters = new GameTypeConverters();

  private final EntityDeletionOrUpdateAdapter<Game> __updateAdapterOfGame;

  public GameDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGame = new EntityInsertionAdapter<Game>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `table_game` (`id`,`teamAName`,`teamBName`,`teamAScore`,`teamBScore`,`date`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Game value) {
        final String _tmp = __gameTypeConverters.fromUUID(value.getId());
        if (_tmp == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, _tmp);
        }
        if (value.getTeamAName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTeamAName());
        }
        if (value.getTeamBName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTeamBName());
        }
        stmt.bindLong(4, value.getTeamAScore());
        stmt.bindLong(5, value.getTeamBScore());
        final Long _tmp_1 = __gameTypeConverters.fromDate(value.getDate());
        if (_tmp_1 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp_1);
        }
      }
    };
    this.__updateAdapterOfGame = new EntityDeletionOrUpdateAdapter<Game>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `table_game` SET `id` = ?,`teamAName` = ?,`teamBName` = ?,`teamAScore` = ?,`teamBScore` = ?,`date` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Game value) {
        final String _tmp = __gameTypeConverters.fromUUID(value.getId());
        if (_tmp == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, _tmp);
        }
        if (value.getTeamAName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTeamAName());
        }
        if (value.getTeamBName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTeamBName());
        }
        stmt.bindLong(4, value.getTeamAScore());
        stmt.bindLong(5, value.getTeamBScore());
        final Long _tmp_1 = __gameTypeConverters.fromDate(value.getDate());
        if (_tmp_1 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp_1);
        }
        final String _tmp_2 = __gameTypeConverters.fromUUID(value.getId());
        if (_tmp_2 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp_2);
        }
      }
    };
  }

  @Override
  public void addGame(final Game game) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGame.insert(game);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateGame(final Game game) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfGame.handle(game);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Game>> getGames(final boolean isTeamAWinning) {
    final String _sql = "SELECT * FROM table_game where (teamAScore > teamBScore) = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp = isTeamAWinning ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    return __db.getInvalidationTracker().createLiveData(new String[]{"table_game"}, false, new Callable<List<Game>>() {
      @Override
      public List<Game> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTeamAName = CursorUtil.getColumnIndexOrThrow(_cursor, "teamAName");
          final int _cursorIndexOfTeamBName = CursorUtil.getColumnIndexOrThrow(_cursor, "teamBName");
          final int _cursorIndexOfTeamAScore = CursorUtil.getColumnIndexOrThrow(_cursor, "teamAScore");
          final int _cursorIndexOfTeamBScore = CursorUtil.getColumnIndexOrThrow(_cursor, "teamBScore");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final List<Game> _result = new ArrayList<Game>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Game _item;
            final UUID _tmpId;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __gameTypeConverters.toUUID(_tmp_1);
            final String _tmpTeamAName;
            if (_cursor.isNull(_cursorIndexOfTeamAName)) {
              _tmpTeamAName = null;
            } else {
              _tmpTeamAName = _cursor.getString(_cursorIndexOfTeamAName);
            }
            final String _tmpTeamBName;
            if (_cursor.isNull(_cursorIndexOfTeamBName)) {
              _tmpTeamBName = null;
            } else {
              _tmpTeamBName = _cursor.getString(_cursorIndexOfTeamBName);
            }
            final int _tmpTeamAScore;
            _tmpTeamAScore = _cursor.getInt(_cursorIndexOfTeamAScore);
            final int _tmpTeamBScore;
            _tmpTeamBScore = _cursor.getInt(_cursorIndexOfTeamBScore);
            final Date _tmpDate;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __gameTypeConverters.toDate(_tmp_2);
            _item = new Game(_tmpId,_tmpTeamAName,_tmpTeamBName,_tmpTeamAScore,_tmpTeamBScore,_tmpDate);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Game> getGame(final UUID id) {
    final String _sql = "SELECT * FROM table_game WHERE id=(?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp = __gameTypeConverters.fromUUID(id);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"table_game"}, false, new Callable<Game>() {
      @Override
      public Game call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTeamAName = CursorUtil.getColumnIndexOrThrow(_cursor, "teamAName");
          final int _cursorIndexOfTeamBName = CursorUtil.getColumnIndexOrThrow(_cursor, "teamBName");
          final int _cursorIndexOfTeamAScore = CursorUtil.getColumnIndexOrThrow(_cursor, "teamAScore");
          final int _cursorIndexOfTeamBScore = CursorUtil.getColumnIndexOrThrow(_cursor, "teamBScore");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final Game _result;
          if(_cursor.moveToFirst()) {
            final UUID _tmpId;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __gameTypeConverters.toUUID(_tmp_1);
            final String _tmpTeamAName;
            if (_cursor.isNull(_cursorIndexOfTeamAName)) {
              _tmpTeamAName = null;
            } else {
              _tmpTeamAName = _cursor.getString(_cursorIndexOfTeamAName);
            }
            final String _tmpTeamBName;
            if (_cursor.isNull(_cursorIndexOfTeamBName)) {
              _tmpTeamBName = null;
            } else {
              _tmpTeamBName = _cursor.getString(_cursorIndexOfTeamBName);
            }
            final int _tmpTeamAScore;
            _tmpTeamAScore = _cursor.getInt(_cursorIndexOfTeamAScore);
            final int _tmpTeamBScore;
            _tmpTeamBScore = _cursor.getInt(_cursorIndexOfTeamBScore);
            final Date _tmpDate;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __gameTypeConverters.toDate(_tmp_2);
            _result = new Game(_tmpId,_tmpTeamAName,_tmpTeamBName,_tmpTeamAScore,_tmpTeamBScore,_tmpDate);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
