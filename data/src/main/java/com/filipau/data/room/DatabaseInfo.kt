package com.filipau.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1)
abstract class DatabaseInfo : RoomDatabase() {

    abstract fun getUserDAO(): UserDAO

    companion object {
        fun init(context: Context) =
            Room.databaseBuilder(context, DatabaseInfo::class.java, "database")
                .build()
    }
}