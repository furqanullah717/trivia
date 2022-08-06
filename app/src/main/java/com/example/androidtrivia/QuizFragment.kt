package com.example.androidtrivia

import android.os.Bundle
import android.service.autofill.TextValueSanitizer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 * Use the [QuizFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizFragment : Fragment(), OnClickListener {

    lateinit var tvCount: TextView
    lateinit var tvQuestion: TextView
    lateinit var btOption1: Button
    lateinit var btOption2: Button
    lateinit var btOption3: Button
    lateinit var btOption4: Button

    var currentQuestionIndex = 0
    val listOfQuestion = QuizHandler.getQuestions()
    lateinit var currentQuestion: Question
    var score = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvCount = view.findViewById(R.id.tvCount)
        tvQuestion = view.findViewById(R.id.tvQuestion)
        btOption1 = view.findViewById(R.id.btOption1)
        btOption2 = view.findViewById(R.id.btOption2)
        btOption3 = view.findViewById(R.id.btOption3)
        btOption4 = view.findViewById(R.id.btOption4)

        btOption1.setOnClickListener(this)
        btOption2.setOnClickListener(this)
        btOption3.setOnClickListener(this)
        btOption4.setOnClickListener(this)

        displayQuestion()
    }

    fun displayQuestion() {
        if(currentQuestionIndex >= listOfQuestion.size){
            //navigate to results
            val bundle = Bundle()
            bundle.putInt("result",score)
            findNavController().navigate(R.id.action_quizFragment_to_resultsFragment,bundle)
            return
        }
        currentQuestion = listOfQuestion[currentQuestionIndex++]
        tvQuestion.text = currentQuestion.question
        btOption1.text = currentQuestion.option1
        btOption2.text = currentQuestion.option2
        btOption3.text = currentQuestion.option3
        btOption4.text = currentQuestion.option4
    }

    override fun onClick(v: View?) {
        //compare results
        val selectedOption = when (v?.id) {
            R.id.btOption1 -> currentQuestion.option1
            R.id.btOption2 -> currentQuestion.option2
            R.id.btOption3 -> currentQuestion.option3
            else -> currentQuestion.option4
        }

        if (selectedOption.equals(currentQuestion.answer)) {
            score++
        }
        displayQuestion()
    }

}