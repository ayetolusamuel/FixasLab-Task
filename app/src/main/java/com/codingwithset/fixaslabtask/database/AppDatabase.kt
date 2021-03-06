package com.codingwithset.fixaslabtask.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codingwithset.fixaslabtask.model.Data

/*
* database creation
*/

@Database(
    entities = [Data::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getDataDao(): DataDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()


        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {

            instance ?: buildDatabase(context).also {
                instance = it

            }

        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "data.db"
            )
                .build()


    }
}