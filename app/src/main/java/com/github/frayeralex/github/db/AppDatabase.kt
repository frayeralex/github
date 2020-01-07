package com.github.frayeralex.github.db

import android.content.Context
import androidx.room.*

@Database(entities = arrayOf(ProfileEntity::class), version = 1, exportSchema = false)
public abstract class AppDatabase : RoomDatabase() {
    abstract fun profileDao(): ProfileDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "DB"
                ).build().let {
                    INSTANCE = it
                    return it
                }
            }
        }
    }
}