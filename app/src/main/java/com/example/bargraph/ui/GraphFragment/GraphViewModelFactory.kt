package com.example.bargraph.ui.GraphFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bargraph.GraphViewModel
import com.example.bargraph.data.Repository.EmployeeRepository

class GraphViewModelFactory(private val repository: EmployeeRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GraphViewModel(repository) as T
    }
}