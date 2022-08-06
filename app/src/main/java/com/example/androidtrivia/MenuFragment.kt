package com.example.androidtrivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

/**
 * A simple [Fragment] subclass.
 * Use the [MenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuFragment : Fragment() {
    lateinit var buttonStart: Button
    lateinit var buttonRules: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonStart  =  view.findViewById(R.id.btStartQuiz)
        buttonRules  =  view.findViewById(R.id.btRules)
        buttonStart.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_quizFragment)
        }
        buttonRules.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_rulesFragment)
        }
    }

}