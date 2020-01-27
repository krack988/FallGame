package com.pmihail.fallgame.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pmihail.fallgame.R
import com.pmihail.fallgame.adapters.CardAdapter
import com.pmihail.fallgame.adapters.ItemOffsetDecoration
import kotlinx.android.synthetic.main.start_fragment.*

class StartFragment: Fragment() {

//    private lateinit var selected: Model
    private var hasHeader: Boolean = false
    private var adapter: CardAdapter? = null
    private var layoutManager: LinearLayoutManager? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = CardAdapter()
        layoutManager = LinearLayoutManager(context)
        val view = inflater.inflate(R.layout.start_fragment, container, false)
        val btnNext = view.findViewById<Button>(R.id.btnNext)
        val questionList = view.findViewById<RecyclerView>(R.id.questionList)
        questionList.layoutManager = layoutManager
        questionList.addItemDecoration(ItemOffsetDecoration(context))
        questionList.adapter = adapter
        btnNext.setOnClickListener {
//            Navigation.findNavController(view).navigate(R.id.detailsFragment)
            runLayoutAnimation()
        }

        return view
    }

    private fun runLayoutAnimation() = questionList.apply {
        layoutAnimation = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_from_right)
        adapter?.notifyDataSetChanged()
        scheduleLayoutAnimation()
    }
}