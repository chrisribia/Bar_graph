package com.example.bargraph.data.Repository

import com.example.bargraph.data.db.AppDataBase
import com.example.bargraph.data.db.Entity.Employee
import com.example.bargraph.data.network.MyApi
import com.example.bargraph.data.network.SafeApiRequest

class EmployeeRepository(
    private val api : MyApi,
    private val db : AppDataBase
) : SafeApiRequest(){

    suspend fun saveEmployees(employees: List<Employee>) = db.getEmployeeDao().saveAllEmployees(employees)

    fun getEmployees() = db.getEmployeeDao().getEmployees()
}