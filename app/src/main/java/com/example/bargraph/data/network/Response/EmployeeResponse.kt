package com.example.bargraph.data.network.Response

import com.example.bargraph.data.db.Entity.Employee

data class EmployeeResponse (

    var error : Boolean,
    var employee :List<Employee>
)