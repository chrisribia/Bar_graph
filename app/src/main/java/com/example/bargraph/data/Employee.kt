package com.example.bargraph.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Employee(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val designation: String,
    val city: String,
    val joiningDate: String,
    val salary: String,
    var image: String?,
    var imageTime: String?
)