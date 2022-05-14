package com.example.roomdao.app

import android.app.Application
import com.example.roomdao.data.db.Database
import timber.log.Timber

class RoomDaoApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Database.init(this)
    }

}