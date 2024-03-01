package com.example.gceolmcq.roomDB;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.gceolmcq.datamodels.SubjectPackageData;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SubjectPackageDao_Impl implements SubjectPackageDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SubjectPackageData> __insertionAdapterOfSubjectPackageData;

  private final EntityDeletionOrUpdateAdapter<SubjectPackageData> __updateAdapterOfSubjectPackageData;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public SubjectPackageDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSubjectPackageData = new EntityInsertionAdapter<SubjectPackageData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `subject_package_table` (`subjectIndex`,`subject_name`,`package_name`,`activated_on`,`expires_on`,`package_status`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SubjectPackageData value) {
        if (value.getSubjectIndex() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getSubjectIndex());
        }
        if (value.getSubjectName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSubjectName());
        }
        if (value.getPackageName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPackageName());
        }
        if (value.getActivatedOn() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getActivatedOn());
        }
        if (value.getExpiresOn() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getExpiresOn());
        }
        final Integer _tmp;
        _tmp = value.isPackageActive() == null ? null : (value.isPackageActive() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp);
        }
      }
    };
    this.__updateAdapterOfSubjectPackageData = new EntityDeletionOrUpdateAdapter<SubjectPackageData>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `subject_package_table` SET `subjectIndex` = ?,`subject_name` = ?,`package_name` = ?,`activated_on` = ?,`expires_on` = ?,`package_status` = ? WHERE `subjectIndex` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SubjectPackageData value) {
        if (value.getSubjectIndex() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getSubjectIndex());
        }
        if (value.getSubjectName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSubjectName());
        }
        if (value.getPackageName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPackageName());
        }
        if (value.getActivatedOn() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getActivatedOn());
        }
        if (value.getExpiresOn() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getExpiresOn());
        }
        final Integer _tmp;
        _tmp = value.isPackageActive() == null ? null : (value.isPackageActive() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp);
        }
        if (value.getSubjectIndex() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getSubjectIndex());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM subject_package_table";
        return _query;
      }
    };
  }

  @Override
  public void insert(final SubjectPackageData subjectPackageData) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSubjectPackageData.insert(subjectPackageData);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int update(final SubjectPackageData subjectPackageData) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfSubjectPackageData.handle(subjectPackageData);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<SubjectPackageData> getAllSubjectsPackages() {
    final String _sql = "SELECT * FROM subject_package_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSubjectIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "subjectIndex");
      final int _cursorIndexOfSubjectName = CursorUtil.getColumnIndexOrThrow(_cursor, "subject_name");
      final int _cursorIndexOfPackageName = CursorUtil.getColumnIndexOrThrow(_cursor, "package_name");
      final int _cursorIndexOfActivatedOn = CursorUtil.getColumnIndexOrThrow(_cursor, "activated_on");
      final int _cursorIndexOfExpiresOn = CursorUtil.getColumnIndexOrThrow(_cursor, "expires_on");
      final int _cursorIndexOfIsPackageActive = CursorUtil.getColumnIndexOrThrow(_cursor, "package_status");
      final List<SubjectPackageData> _result = new ArrayList<SubjectPackageData>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SubjectPackageData _item;
        _item = new SubjectPackageData();
        final Integer _tmpSubjectIndex;
        if (_cursor.isNull(_cursorIndexOfSubjectIndex)) {
          _tmpSubjectIndex = null;
        } else {
          _tmpSubjectIndex = _cursor.getInt(_cursorIndexOfSubjectIndex);
        }
        _item.setSubjectIndex(_tmpSubjectIndex);
        final String _tmpSubjectName;
        if (_cursor.isNull(_cursorIndexOfSubjectName)) {
          _tmpSubjectName = null;
        } else {
          _tmpSubjectName = _cursor.getString(_cursorIndexOfSubjectName);
        }
        _item.setSubjectName(_tmpSubjectName);
        final String _tmpPackageName;
        if (_cursor.isNull(_cursorIndexOfPackageName)) {
          _tmpPackageName = null;
        } else {
          _tmpPackageName = _cursor.getString(_cursorIndexOfPackageName);
        }
        _item.setPackageName(_tmpPackageName);
        final String _tmpActivatedOn;
        if (_cursor.isNull(_cursorIndexOfActivatedOn)) {
          _tmpActivatedOn = null;
        } else {
          _tmpActivatedOn = _cursor.getString(_cursorIndexOfActivatedOn);
        }
        _item.setActivatedOn(_tmpActivatedOn);
        final String _tmpExpiresOn;
        if (_cursor.isNull(_cursorIndexOfExpiresOn)) {
          _tmpExpiresOn = null;
        } else {
          _tmpExpiresOn = _cursor.getString(_cursorIndexOfExpiresOn);
        }
        _item.setExpiresOn(_tmpExpiresOn);
        final Boolean _tmpIsPackageActive;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfIsPackageActive)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfIsPackageActive);
        }
        _tmpIsPackageActive = _tmp == null ? null : _tmp != 0;
        _item.setPackageActive(_tmpIsPackageActive);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public SubjectPackageData findBySubjectName(final String subjectName) {
    final String _sql = "SELECT * FROM subject_package_table WHERE subject_name LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (subjectName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, subjectName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSubjectIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "subjectIndex");
      final int _cursorIndexOfSubjectName = CursorUtil.getColumnIndexOrThrow(_cursor, "subject_name");
      final int _cursorIndexOfPackageName = CursorUtil.getColumnIndexOrThrow(_cursor, "package_name");
      final int _cursorIndexOfActivatedOn = CursorUtil.getColumnIndexOrThrow(_cursor, "activated_on");
      final int _cursorIndexOfExpiresOn = CursorUtil.getColumnIndexOrThrow(_cursor, "expires_on");
      final int _cursorIndexOfIsPackageActive = CursorUtil.getColumnIndexOrThrow(_cursor, "package_status");
      final SubjectPackageData _result;
      if(_cursor.moveToFirst()) {
        _result = new SubjectPackageData();
        final Integer _tmpSubjectIndex;
        if (_cursor.isNull(_cursorIndexOfSubjectIndex)) {
          _tmpSubjectIndex = null;
        } else {
          _tmpSubjectIndex = _cursor.getInt(_cursorIndexOfSubjectIndex);
        }
        _result.setSubjectIndex(_tmpSubjectIndex);
        final String _tmpSubjectName;
        if (_cursor.isNull(_cursorIndexOfSubjectName)) {
          _tmpSubjectName = null;
        } else {
          _tmpSubjectName = _cursor.getString(_cursorIndexOfSubjectName);
        }
        _result.setSubjectName(_tmpSubjectName);
        final String _tmpPackageName;
        if (_cursor.isNull(_cursorIndexOfPackageName)) {
          _tmpPackageName = null;
        } else {
          _tmpPackageName = _cursor.getString(_cursorIndexOfPackageName);
        }
        _result.setPackageName(_tmpPackageName);
        final String _tmpActivatedOn;
        if (_cursor.isNull(_cursorIndexOfActivatedOn)) {
          _tmpActivatedOn = null;
        } else {
          _tmpActivatedOn = _cursor.getString(_cursorIndexOfActivatedOn);
        }
        _result.setActivatedOn(_tmpActivatedOn);
        final String _tmpExpiresOn;
        if (_cursor.isNull(_cursorIndexOfExpiresOn)) {
          _tmpExpiresOn = null;
        } else {
          _tmpExpiresOn = _cursor.getString(_cursorIndexOfExpiresOn);
        }
        _result.setExpiresOn(_tmpExpiresOn);
        final Boolean _tmpIsPackageActive;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfIsPackageActive)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfIsPackageActive);
        }
        _tmpIsPackageActive = _tmp == null ? null : _tmp != 0;
        _result.setPackageActive(_tmpIsPackageActive);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
