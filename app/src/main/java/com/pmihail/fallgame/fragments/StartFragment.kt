package com.pmihail.fallgame.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pmihail.fallgame.R
import com.pmihail.fallgame.adapters.CardAdapter
import kotlinx.android.synthetic.main.start_fragment.*

class StartFragment: Fragment() {

//    private lateinit var selected: Model
    private var hasHeader: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.start_fragment, container, false)
        val btnNext = view.findViewById<Button>(R.id.btnNext)
        btnNext.setOnClickListener {
//            findNavController().navigate(R.id.detailsFragment)
            Navigation.findNavController(view).navigate(R.id.detailsFragment)
        }

//        layoutManager = LinearLayoutManager(context)
//        adapter = CardAdapter(withHeader = withHeader)

        return view
    }
}