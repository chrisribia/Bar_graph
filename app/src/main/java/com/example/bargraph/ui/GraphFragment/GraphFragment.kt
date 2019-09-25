package com.example.bargraph.ui.GraphFragment


import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.bargraph.GraphViewModel
import com.example.bargraph.R
import com.example.bargraph.data.db.Entity.Employee
import com.example.bargraph.databinding.FragmentGraphBinding
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.android.synthetic.main.fragment_graph.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

import androidx.lifecycle.Observer


class GraphFragment : Fragment(), KodeinAware {
    override val kodein by kodein()
    private val factory: GraphViewModelFactory by instance()

    private lateinit var viewModel: GraphViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val binding : FragmentGraphBinding =  DataBindingUtil.inflate(inflater, R.layout.fragment_graph, container, false)
        viewModel = ViewModelProviders.of(this, factory).get(GraphViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.fetchTickets()
        viewModel.employee.observe(this, Observer {
            showBarChart(it)
        })

    }

    private fun showBarChart( employee: List<Employee>) {

                val entries = mutableListOf<BarEntry>()
                     var x = 0
                    employee.forEach {

                        entries.add(
                            BarEntry(
                                x.toFloat(),
                                it.salary.toFloat()
                            )
                        )
                        x++
                    }



            val barData = BarData(BarDataSet(entries, "Salaries"))
            chart.data = barData
        chart.animateY(5000)

    }


    override fun onDestroy() {
        super.onDestroy()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }




}
