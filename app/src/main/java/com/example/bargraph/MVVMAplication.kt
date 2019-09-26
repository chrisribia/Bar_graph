package com.example.bargraph

import android.app.Application
import androidx.databinding.DataBindingUtil.bind
import com.example.bargraph.data.Repository.EmployeeRepository
import com.example.bargraph.data.db.AppDataBase
import com.example.bargraph.data.db.Entity.Employee
import com.example.bargraph.data.network.MyApi
import com.example.bargraph.data.network.NetworkConnectionInterceptor
import com.example.bargraph.ui.GraphFragment.GraphViewModelFactory
import com.example.bargraph.ui.MapFragment.MapViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


class MVVMAplication: Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMAplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDataBase(instance()) }
        bind() from singleton { EmployeeRepository(instance(), instance()) }
        bind() from provider { GraphViewModelFactory(instance()) }
        bind() from provider { MapViewModelFactory(instance()) }


    }
}