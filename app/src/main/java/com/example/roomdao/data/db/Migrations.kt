package com.example.roomdao.data.db

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import timber.log.Timber

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        Timber.d("migration 1-2 start")
        database.execSQL("ALTER TABLE employees RENAME COLUMN employee_department_id TO employee_departments_id")
        Timber.d("migration 1-2 success")
    }
}
