package com.example.bargraph

import androidx.lifecycle.ViewModel
import com.example.bargraph.data.Repository.EmployeeRepository
import com.example.bargraph.utils.Coroutines

class GraphViewModel(
    private val repository: EmployeeRepository): ViewModel()
{

    val employee by lazy {

        repository.getEmployees()
    }


    fun fetchTickets(){
        try {
            Coroutines.io{
                repository.fetchEmployees()
            }
        }catch (e : Exception){
            e.printStackTrace()
        }

    }
}