package com.example.bargraph.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bargraph.R


class GraphFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val mview : View = inflater.inflate(R.layout.fragment_graph, container, false)

    return mview
    }




}
