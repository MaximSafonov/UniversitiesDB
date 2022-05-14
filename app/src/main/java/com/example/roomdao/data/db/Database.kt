package com.example.roomdao.data.db

import android.content.Context
import androidx.room.Room

object Database {

    lateinit var databaseInstance: UniversityDatabase
        private set

    fun init(context: Context) {
        databaseInstance = Room.databaseBuilder(
            context,
            UniversityDatabase::class.java,
            UniversityDatabase.DATABASE_NAME
        )
            .addMigrations(MIGRATION_1_2)
            .build()
    }
}