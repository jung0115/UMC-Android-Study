package com.bicontest.umc_week8

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bicontest.umc_week8.dao.MemoDataDao
import com.bicontest.umc_week8.db_entity.MemoDataEntity

@Database(entities = arrayOf(MemoDataEntity::class), version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun memoDataDao(): MemoDataDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "database-memo"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}