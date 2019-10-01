package com.example.bargraph.ui.MapFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bargraph.data.Repository.EmployeeRepository

class MapViewModelFactory(private val repository: EmployeeRepository)
    :  ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MapViewModel(repository) as T
    }
}