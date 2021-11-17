package com.example.s205353lykkehjulet

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
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
    private var points: TextView? = null
    private val viewModel : GameViewModel by viewModels()
    private var player : Player? = null
    private var luckyWheel : ImageView? = null
    private var lives: TextView? = null

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
        points = binding.points
        player = game.getPlayer()
        luckyWheel = binding.luckyWheel
        lives = binding.lifeCount


        binding.spinWheelButton.setOnClickListener(){
            game.spinTheWheel()
            spinningAnimation()
            viewModel.setResultValue("")
            Handler().postDelayed({
                viewModel.setResultValue(game.getResult())
                viewModel.setPointsValue(player!!.getPoints())
            }, 1010)

        }

        binding.guessButton.setOnClickListener(){
            HiddenWord.displayLetterIfTrue(binding.guessInputField.text.toString())
            binding.guessInputField.text.clear()
            if (HiddenWord.ifLetterIsRight()){
                player!!.addPoints(HiddenWord.getRightGuesses() * game.getPointsToWin())
                viewModel.setPointsValue(player!!.getPoints())
                HiddenWord.setLetterIsRight(false)
            } else {
                player!!.loseLife()
                viewModel.setLivesValue(player!!.getLives())
                if (player!!.getLives() == 0)
                    findNavController().navigate(R.id.action_gameFragment_to_lostFragment)
            }

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

        viewModel.currentPoints.observe(viewLifecycleOwner, {
                newPoints -> binding.points.text = newPoints.toString()
        })

        viewModel.currentLives.observe(viewLifecycleOwner, {
                newLives -> binding.lifeCount.text = newLives.toString()
        })



    }

    fun spinningAnimation(){
        val angle = Math.random() * 360
        val animRotateClick = AnimationUtils.loadAnimation(context,R.anim.rotation)
        luckyWheel!!.startAnimation(animRotateClick)
        luckyWheel!!.setRotation(angle.toFloat())
    }


}




