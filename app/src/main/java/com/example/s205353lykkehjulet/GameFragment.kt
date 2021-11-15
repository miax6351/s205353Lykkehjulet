package com.example.s205353lykkehjulet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.MainThread
import androidx.core.view.get
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.s205353lykkehjulet.databinding.FragmentGameBinding


class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private var game = Game()
    private var result: TextView? = null
    private val viewModel : GameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        game.startGame()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false,)
        adapter = RecyclerAdapter()
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
        result = binding.resultView


        binding.spinWheelButton.setOnClickListener(){
            game.spinTheWheel()
            println("onclick value")
            println(game.getResult())
            viewModel.setValue(game.getResult())

        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Create the observer which updates the UI.
        val gameObserver = Observer<String> { spin ->
            // Update the UI, in this case, a TextView.
            result?.text  = game.getResult()
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.currentResult.observe(viewLifecycleOwner, {
                newWord -> binding.resultView.text = newWord
        })


    }


}




