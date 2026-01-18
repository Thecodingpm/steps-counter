package com.abbusteps.app.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.abbusteps.app.data.model.StepRecord;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class StepRecordDao_Impl implements StepRecordDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<StepRecord> __insertionAdapterOfStepRecord;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSteps;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public StepRecordDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStepRecord = new EntityInsertionAdapter<StepRecord>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `step_records` (`date`,`steps`,`distance`,`calories`,`lastUpdated`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final StepRecord entity) {
        if (entity.getDate() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getDate());
        }
        statement.bindLong(2, entity.getSteps());
        statement.bindDouble(3, entity.getDistance());
        statement.bindDouble(4, entity.getCalories());
        statement.bindLong(5, entity.getLastUpdated());
      }
    };
    this.__preparedStmtOfUpdateSteps = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE step_records SET steps = ?, distance = ?, calories = ?, lastUpdated = ? WHERE date = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM step_records";
        return _query;
      }
    };
  }

  @Override
  public Object insertStepRecord(final StepRecord stepRecord,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfStepRecord.insert(stepRecord);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateSteps(final String date, final int steps, final float distance,
      final float calories, final long lastUpdated, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSteps.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, steps);
        _argIndex = 2;
        _stmt.bindDouble(_argIndex, distance);
        _argIndex = 3;
        _stmt.bindDouble(_argIndex, calories);
        _argIndex = 4;
        _stmt.bindLong(_argIndex, lastUpdated);
        _argIndex = 5;
        if (date == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, date);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateSteps.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getStepRecord(final String date,
      final Continuation<? super StepRecord> $completion) {
    final String _sql = "SELECT * FROM step_records WHERE date = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<StepRecord>() {
      @Override
      @Nullable
      public StepRecord call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfSteps = CursorUtil.getColumnIndexOrThrow(_cursor, "steps");
          final int _cursorIndexOfDistance = CursorUtil.getColumnIndexOrThrow(_cursor, "distance");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdated");
          final StepRecord _result;
          if (_cursor.moveToFirst()) {
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final int _tmpSteps;
            _tmpSteps = _cursor.getInt(_cursorIndexOfSteps);
            final float _tmpDistance;
            _tmpDistance = _cursor.getFloat(_cursorIndexOfDistance);
            final float _tmpCalories;
            _tmpCalories = _cursor.getFloat(_cursorIndexOfCalories);
            final long _tmpLastUpdated;
            _tmpLastUpdated = _cursor.getLong(_cursorIndexOfLastUpdated);
            _result = new StepRecord(_tmpDate,_tmpSteps,_tmpDistance,_tmpCalories,_tmpLastUpdated);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<StepRecord> getTodayStepRecord(final String date) {
    final String _sql = "SELECT * FROM step_records WHERE date = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"step_records"}, new Callable<StepRecord>() {
      @Override
      @Nullable
      public StepRecord call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfSteps = CursorUtil.getColumnIndexOrThrow(_cursor, "steps");
          final int _cursorIndexOfDistance = CursorUtil.getColumnIndexOrThrow(_cursor, "distance");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdated");
          final StepRecord _result;
          if (_cursor.moveToFirst()) {
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final int _tmpSteps;
            _tmpSteps = _cursor.getInt(_cursorIndexOfSteps);
            final float _tmpDistance;
            _tmpDistance = _cursor.getFloat(_cursorIndexOfDistance);
            final float _tmpCalories;
            _tmpCalories = _cursor.getFloat(_cursorIndexOfCalories);
            final long _tmpLastUpdated;
            _tmpLastUpdated = _cursor.getLong(_cursorIndexOfLastUpdated);
            _result = new StepRecord(_tmpDate,_tmpSteps,_tmpDistance,_tmpCalories,_tmpLastUpdated);
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

  @Override
  public Flow<List<StepRecord>> getAllStepRecords() {
    final String _sql = "SELECT * FROM step_records ORDER BY date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"step_records"}, new Callable<List<StepRecord>>() {
      @Override
      @NonNull
      public List<StepRecord> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfSteps = CursorUtil.getColumnIndexOrThrow(_cursor, "steps");
          final int _cursorIndexOfDistance = CursorUtil.getColumnIndexOrThrow(_cursor, "distance");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdated");
          final List<StepRecord> _result = new ArrayList<StepRecord>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final StepRecord _item;
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final int _tmpSteps;
            _tmpSteps = _cursor.getInt(_cursorIndexOfSteps);
            final float _tmpDistance;
            _tmpDistance = _cursor.getFloat(_cursorIndexOfDistance);
            final float _tmpCalories;
            _tmpCalories = _cursor.getFloat(_cursorIndexOfCalories);
            final long _tmpLastUpdated;
            _tmpLastUpdated = _cursor.getLong(_cursorIndexOfLastUpdated);
            _item = new StepRecord(_tmpDate,_tmpSteps,_tmpDistance,_tmpCalories,_tmpLastUpdated);
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
  public Object getStepRecordsBetween(final String startDate, final String endDate,
      final Continuation<? super List<StepRecord>> $completion) {
    final String _sql = "SELECT * FROM step_records WHERE date BETWEEN ? AND ? ORDER BY date ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (startDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, startDate);
    }
    _argIndex = 2;
    if (endDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, endDate);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<StepRecord>>() {
      @Override
      @NonNull
      public List<StepRecord> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfSteps = CursorUtil.getColumnIndexOrThrow(_cursor, "steps");
          final int _cursorIndexOfDistance = CursorUtil.getColumnIndexOrThrow(_cursor, "distance");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdated");
          final List<StepRecord> _result = new ArrayList<StepRecord>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final StepRecord _item;
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final int _tmpSteps;
            _tmpSteps = _cursor.getInt(_cursorIndexOfSteps);
            final float _tmpDistance;
            _tmpDistance = _cursor.getFloat(_cursorIndexOfDistance);
            final float _tmpCalories;
            _tmpCalories = _cursor.getFloat(_cursorIndexOfCalories);
            final long _tmpLastUpdated;
            _tmpLastUpdated = _cursor.getLong(_cursorIndexOfLastUpdated);
            _item = new StepRecord(_tmpDate,_tmpSteps,_tmpDistance,_tmpCalories,_tmpLastUpdated);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getStepRecordsSince(final String startDate,
      final Continuation<? super List<StepRecord>> $completion) {
    final String _sql = "SELECT * FROM step_records WHERE date >= ? ORDER BY date ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (startDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, startDate);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<StepRecord>>() {
      @Override
      @NonNull
      public List<StepRecord> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfSteps = CursorUtil.getColumnIndexOrThrow(_cursor, "steps");
          final int _cursorIndexOfDistance = CursorUtil.getColumnIndexOrThrow(_cursor, "distance");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdated");
          final List<StepRecord> _result = new ArrayList<StepRecord>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final StepRecord _item;
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final int _tmpSteps;
            _tmpSteps = _cursor.getInt(_cursorIndexOfSteps);
            final float _tmpDistance;
            _tmpDistance = _cursor.getFloat(_cursorIndexOfDistance);
            final float _tmpCalories;
            _tmpCalories = _cursor.getFloat(_cursorIndexOfCalories);
            final long _tmpLastUpdated;
            _tmpLastUpdated = _cursor.getLong(_cursorIndexOfLastUpdated);
            _item = new StepRecord(_tmpDate,_tmpSteps,_tmpDistance,_tmpCalories,_tmpLastUpdated);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getWeeklySteps(final String startDate,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT SUM(steps) FROM step_records WHERE date >= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (startDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, startDate);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @Nullable
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getMonthlySteps(final String startDate, final String endDate,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT SUM(steps) FROM step_records WHERE date >= ? AND date <= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (startDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, startDate);
    }
    _argIndex = 2;
    if (endDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, endDate);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @Nullable
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
