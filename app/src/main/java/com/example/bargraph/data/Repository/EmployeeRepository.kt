package com.example.bargraph.data.Repository

import androidx.lifecycle.MutableLiveData
import com.example.bargraph.data.db.AppDataBase
import com.example.bargraph.data.db.Entity.Employee
import com.example.bargraph.data.network.MyApi
import com.example.bargraph.data.network.SafeApiRequest
import com.example.bargraph.utils.Coroutines

class EmployeeRepository(
    private val api : MyApi,
    private val db : AppDataBase
) : SafeApiRequest(){



    private val employee = MutableLiveData<List<Employee>>()


    init {
        employee.observeForever {
            saveEmployees(it)
        }


    }


    suspend fun fetchEmployees() {
        val response = apiRequest { api.getEmployee() }
        employee.postValue(response.employee)

    }
    private fun saveEmployees(employee: List<Employee>) {
        Coroutines.io {
            db.getEmployeeDao().saveAllEmployees(employee)
        }
    }


    fun getEmployees() = db.getEmployeeDao().getEmployees()
}