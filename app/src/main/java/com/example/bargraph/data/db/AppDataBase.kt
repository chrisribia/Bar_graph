package com.example.bargraph.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bargraph.data.db.Entity.Employee
import com.example.bargraph.data.db.Entity.EmployeeDao


@Database(
    entities = [Employee::class],
    version = 1
)
abstract  class AppDataBase : RoomDatabase(){


    abstract fun getEmployeeDao(): EmployeeDao

    companion object {

        @Volatile
        private var instance: AppDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(
                LOCK
        ) {
            instance
                ?: buildDatabase(context).also {
                    instance = it
                }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "TVSLocal.db"
            ).build()
    }
}