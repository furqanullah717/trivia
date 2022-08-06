package com.example.androidtrivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 * Use the [ResultsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultsFragment : Fragment() {

    lateinit var btGoHome:Button
    lateinit var tvResult:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvResult =  view.findViewById(R.id.tvResult)
        tvResult.text = requireArguments().getInt("result").toString()
        btGoHome =  view.findViewById(R.id.btGoHome)
        btGoHome.setOnClickListener {
            findNavController().navigate(R.id.action_resultsFragment_to_menuFragment)
        }

    }
}