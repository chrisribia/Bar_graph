package com.example.bargraph.data.db.Entity

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EmployeeDao{
            @Insert(onConflict = OnConflictStrategy.REPLACE)
            suspend fun saveAllEmployees(quotes: List<Employee>)

            @Query("SELECT * FROM Employee")
            fun getEmployees(): List<Employee>
}