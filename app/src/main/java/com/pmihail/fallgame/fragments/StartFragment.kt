package com.pmihail.fallgame.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pmihail.fallgame.R
import com.pmihail.fallgame.adapters.CardAdapter
import com.pmihail.fallgame.adapters.ItemOffsetDecoration
import com.pmihail.fallgame.data.AnswerVariant
import com.pmihail.fallgame.data.Question
import kotlinx.android.synthetic.main.start_fragment.*

class StartFragment: Fragment() {

//    private lateinit var selected: Model
    private var hasHeader: Boolean = false
    private var adapter: CardAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
//    private var questionText: TextView? = null

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
        val questionText = view.findViewById<TextView>(R.id.questionText)
        questionList.layoutManager = layoutManager
        questionList.addItemDecoration(ItemOffsetDecoration(context))
        questionList.adapter = adapter
        btnNext.setOnClickListener {
//            Navigation.findNavController(view).navigate(R.id.detailsFragment)
            adapter?.updateList(getQuestionList()[1].answerVariants)
            questionText?.text = getQuestionList()[1].questionText
            runLayoutAnimation()
        }

        adapter?.updateList(getQuestionList()[0].answerVariants)
        questionText?.text = getQuestionList()[0].questionText

        return view
    }

    private fun runLayoutAnimation() = questionList.apply {
        layoutAnimation = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_from_right)
        adapter?.notifyDataSetChanged()
        scheduleLayoutAnimation()
    }

    private fun getQuestionList(): List<Question> {
        val list = ArrayList<Question>()
        var question1 = Question()
        question1.id = "1"
        question1.questionText = "Кто такой Андрюша"
        question1.rightAnswer = 1
        val answerVariant1 = AnswerVariant()
        val answerVariant2 = AnswerVariant()
        answerVariant1.answerText = "ютюбер"
        answerVariant2.answerText = "нет"
        val aList = ArrayList<AnswerVariant>()
        aList.add(answerVariant1)
        aList.add(answerVariant2)
        question1.answerVariants = aList

        var question2 = Question()
        question2.id = "2"
        question2.questionText = "Кто такой Андрюша 2"
        question2.rightAnswer = 2
        val answerVariant3 = AnswerVariant()
        val answerVariant4 = AnswerVariant()
        answerVariant3.answerText = "нет"
        answerVariant4.answerText = "ютюбер"
        val a1List = ArrayList<AnswerVariant>()
        a1List.add(answerVariant3)
        a1List.add(answerVariant4)
        question2.answerVariants = a1List

        list.add(question1)
        list.add(question2)
        return list
    }
}