package com.example.bargraph.ui.MapFragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.bargraph.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import kotlinx.android.synthetic.main.map_fragment.*
import kotlinx.coroutines.Job
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class MapFragment : Fragment(), KodeinAware, OnMapReadyCallback {


    override val kodein by kodein()
    private val factory: MapViewModelFactory by instance()

    private lateinit var googleMap : GoogleMap


    private lateinit var viewModel: MapViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mapView.onCreate(savedInstanceState)
        mapView.onResume()
        mapView.getMapAsync(this)


        viewModel = ViewModelProviders.of(this, factory).get(MapViewModel::class.java)

    }
    override fun onMapReady(map: GoogleMap?) {
        map?.let {
            googleMap = it
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.map_fragment, container, false)
    }



}
