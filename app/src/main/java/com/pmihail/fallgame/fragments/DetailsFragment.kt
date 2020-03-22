package com.pmihail.fallgame.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pmihail.fallgame.R

class DetailsFragment: Fragment() {

    var imageArray = arrayListOf(R.drawable.first, R.drawable.second, R.drawable.threed, R.drawable.four)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.details_fragment, container, false)


        return view
    }
}