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
        return "INSERT OR ABORT INTO `Game` (`id`,`teamA`,`teamB`,`date`,`scoreA`,`scoreB`,`index`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Game value) {
        final String _tmp;
        _tmp = __gameTypeConverters.fromUUID(value.getId());
        if (_tmp == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, _tmp);
        }
        if (value.getTeamA() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTeamA());
        }
        if (value.getTeamB() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTeamB());
        }
        final Long _tmp_1;
        _tmp_1 = __gameTypeConverters.fromDate(value.getDate());
        if (_tmp_1 == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp_1);
        }
        stmt.bindLong(5, value.getScoreA());
        stmt.bindLong(6, value.getScoreB());
        if (value.getIndex() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getIndex());
        }
      }
    };
    this.__updateAdapterOfGame = new EntityDeletionOrUpdateAdapter<Game>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Game` SET `id` = ?,`teamA` = ?,`teamB` = ?,`date` = ?,`scoreA` = ?,`scoreB` = ?,`index` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Game value) {
        final String _tmp;
        _tmp = __gameTypeConverters.fromUUID(value.getId());
        if (_tmp == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, _tmp);
        }
        if (value.getTeamA() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTeamA());
        }
        if (value.getTeamB() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTeamB());
        }
        final Long _tmp_1;
        _tmp_1 = __gameTypeConverters.fromDate(value.getDate());
        if (_tmp_1 == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp_1);
        }
        stmt.bindLong(5, value.getScoreA());
        stmt.bindLong(6, value.getScoreB());
        if (value.getIndex() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getIndex());
        }
        final String _tmp_2;
        _tmp_2 = __gameTypeConverters.fromUUID(value.getId());
        if (_tmp_2 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp_2);
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
  public LiveData<List<Game>> getGames() {
    final String _sql = "SELECT * FROM game";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"game"}, false, new Callable<List<Game>>() {
      @Override
      public List<Game> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTeamA = CursorUtil.getColumnIndexOrThrow(_cursor, "teamA");
          final int _cursorIndexOfTeamB = CursorUtil.getColumnIndexOrThrow(_cursor, "teamB");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfScoreA = CursorUtil.getColumnIndexOrThrow(_cursor, "scoreA");
          final int _cursorIndexOfScoreB = CursorUtil.getColumnIndexOrThrow(_cursor, "scoreB");
          final int _cursorIndexOfIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "index");
          final List<Game> _result = new ArrayList<Game>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Game _item;
            final UUID _tmpId;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfId);
            }
            _tmpId = __gameTypeConverters.toUUID(_tmp);
            final String _tmpTeamA;
            if (_cursor.isNull(_cursorIndexOfTeamA)) {
              _tmpTeamA = null;
            } else {
              _tmpTeamA = _cursor.getString(_cursorIndexOfTeamA);
            }
            final String _tmpTeamB;
            if (_cursor.isNull(_cursorIndexOfTeamB)) {
              _tmpTeamB = null;
            } else {
              _tmpTeamB = _cursor.getString(_cursorIndexOfTeamB);
            }
            final Date _tmpDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __gameTypeConverters.toDate(_tmp_1);
            final int _tmpScoreA;
            _tmpScoreA = _cursor.getInt(_cursorIndexOfScoreA);
            final int _tmpScoreB;
            _tmpScoreB = _cursor.getInt(_cursorIndexOfScoreB);
            final String _tmpIndex;
            if (_cursor.isNull(_cursorIndexOfIndex)) {
              _tmpIndex = null;
            } else {
              _tmpIndex = _cursor.getString(_cursorIndexOfIndex);
            }
            _item = new Game(_tmpId,_tmpTeamA,_tmpTeamB,_tmpDate,_tmpScoreA,_tmpScoreB,_tmpIndex);
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
    final String _sql = "SELECT * FROM game WHERE id=(?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp;
    _tmp = __gameTypeConverters.fromUUID(id);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"game"}, false, new Callable<Game>() {
      @Override
      public Game call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTeamA = CursorUtil.getColumnIndexOrThrow(_cursor, "teamA");
          final int _cursorIndexOfTeamB = CursorUtil.getColumnIndexOrThrow(_cursor, "teamB");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfScoreA = CursorUtil.getColumnIndexOrThrow(_cursor, "scoreA");
          final int _cursorIndexOfScoreB = CursorUtil.getColumnIndexOrThrow(_cursor, "scoreB");
          final int _cursorIndexOfIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "index");
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
            final String _tmpTeamA;
            if (_cursor.isNull(_cursorIndexOfTeamA)) {
              _tmpTeamA = null;
            } else {
              _tmpTeamA = _cursor.getString(_cursorIndexOfTeamA);
            }
            final String _tmpTeamB;
            if (_cursor.isNull(_cursorIndexOfTeamB)) {
              _tmpTeamB = null;
            } else {
              _tmpTeamB = _cursor.getString(_cursorIndexOfTeamB);
            }
            final Date _tmpDate;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __gameTypeConverters.toDate(_tmp_2);
            final int _tmpScoreA;
            _tmpScoreA = _cursor.getInt(_cursorIndexOfScoreA);
            final int _tmpScoreB;
            _tmpScoreB = _cursor.getInt(_cursorIndexOfScoreB);
            final String _tmpIndex;
            if (_cursor.isNull(_cursorIndexOfIndex)) {
              _tmpIndex = null;
            } else {
              _tmpIndex = _cursor.getString(_cursorIndexOfIndex);
            }
            _result = new Game(_tmpId,_tmpTeamA,_tmpTeamB,_tmpDate,_tmpScoreA,_tmpScoreB,_tmpIndex);
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
