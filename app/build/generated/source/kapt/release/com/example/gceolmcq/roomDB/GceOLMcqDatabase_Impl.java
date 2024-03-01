package com.example.gceolmcq.roomDB;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GceOLMcqDatabase_Impl extends GceOLMcqDatabase {
  private volatile SubjectPackageDao _subjectPackageDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `subject_package_table` (`subjectIndex` INTEGER PRIMARY KEY AUTOINCREMENT, `subject_name` TEXT, `package_name` TEXT, `activated_on` TEXT, `expires_on` TEXT, `package_status` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7fb83f2eef91e471f67327d2c94c031e')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `subject_package_table`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsSubjectPackageTable = new HashMap<String, TableInfo.Column>(6);
        _columnsSubjectPackageTable.put("subjectIndex", new TableInfo.Column("subjectIndex", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubjectPackageTable.put("subject_name", new TableInfo.Column("subject_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubjectPackageTable.put("package_name", new TableInfo.Column("package_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubjectPackageTable.put("activated_on", new TableInfo.Column("activated_on", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubjectPackageTable.put("expires_on", new TableInfo.Column("expires_on", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSubjectPackageTable.put("package_status", new TableInfo.Column("package_status", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSubjectPackageTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSubjectPackageTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSubjectPackageTable = new TableInfo("subject_package_table", _columnsSubjectPackageTable, _foreignKeysSubjectPackageTable, _indicesSubjectPackageTable);
        final TableInfo _existingSubjectPackageTable = TableInfo.read(_db, "subject_package_table");
        if (! _infoSubjectPackageTable.equals(_existingSubjectPackageTable)) {
          return new RoomOpenHelper.ValidationResult(false, "subject_package_table(com.example.gceolmcq.datamodels.SubjectPackageData).\n"
                  + " Expected:\n" + _infoSubjectPackageTable + "\n"
                  + " Found:\n" + _existingSubjectPackageTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "7fb83f2eef91e471f67327d2c94c031e", "d6504e73eff31a88bb11eb31c541ee8a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "subject_package_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `subject_package_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(SubjectPackageDao.class, SubjectPackageDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public SubjectPackageDao subjectPackageDao() {
    if (_subjectPackageDao != null) {
      return _subjectPackageDao;
    } else {
      synchronized(this) {
        if(_subjectPackageDao == null) {
          _subjectPackageDao = new SubjectPackageDao_Impl(this);
        }
        return _subjectPackageDao;
      }
    }
  }
}
