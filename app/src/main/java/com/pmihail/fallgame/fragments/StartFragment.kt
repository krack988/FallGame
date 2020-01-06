package com.pmihail.fallgame.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.pmihail.fallgame.R
import kotlinx.android.synthetic.main.start_fragment.*

class StartFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.start_fragment, container, false)
        val btnNext = view.findViewById<Button>(R.id.btnNext)
        btnNext.setOnClickListener {
            findNavController().navigate(R.id.detailsFragment)
        }

        return view
    }
}