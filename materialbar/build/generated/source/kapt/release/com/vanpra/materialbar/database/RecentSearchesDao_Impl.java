package com.vanpra.materialbar.database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RecentSearchesDao_Impl implements RecentSearchesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfRecentSearches;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfRecentSearches;

  public RecentSearchesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRecentSearches = new EntityInsertionAdapter<RecentSearches>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `recentSearches`(`searchID`,`query`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RecentSearches value) {
        if (value.getSearchID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getSearchID());
        }
        if (value.getQuery() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getQuery());
        }
      }
    };
    this.__deletionAdapterOfRecentSearches = new EntityDeletionOrUpdateAdapter<RecentSearches>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `recentSearches` WHERE `searchID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RecentSearches value) {
        if (value.getSearchID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getSearchID());
        }
      }
    };
  }

  @Override
  public long insert(final RecentSearches item) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfRecentSearches.insertAndReturnId(item);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteItem(final RecentSearches item) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfRecentSearches.handle(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<RecentSearches>> getAllItems() {
    final String _sql = "SELECT * FROM recentSearches";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"recentSearches"}, false, new Callable<List<RecentSearches>>() {
      @Override
      public List<RecentSearches> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final int _cursorIndexOfSearchID = CursorUtil.getColumnIndexOrThrow(_cursor, "searchID");
          final int _cursorIndexOfQuery = CursorUtil.getColumnIndexOrThrow(_cursor, "query");
          final List<RecentSearches> _result = new ArrayList<RecentSearches>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final RecentSearches _item;
            final Long _tmpSearchID;
            if (_cursor.isNull(_cursorIndexOfSearchID)) {
              _tmpSearchID = null;
            } else {
              _tmpSearchID = _cursor.getLong(_cursorIndexOfSearchID);
            }
            final String _tmpQuery;
            _tmpQuery = _cursor.getString(_cursorIndexOfQuery);
            _item = new RecentSearches(_tmpSearchID,_tmpQuery);
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
}
