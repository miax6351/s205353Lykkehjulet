package com.example.s205353lykkehjulet

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.*
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.s205353lykkehjulet.databinding.FragmentGameBinding
import android.view.inputmethod.InputMethodManager
import com.example.s205353lykkehjulet.databinding.FragmentWonGameBinding


class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    private var _cardBinding: RecyclerAdapter? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private var game = Game()
    private var result: TextView? = null
    private var points: TextView? = null
    private val viewModel : GameViewModel by viewModels()
    private var player : Player? = null
    private var luckyWheel : ImageView? = null
    private var lives: TextView? = null
    private lateinit var hiddenWord : HiddenWord

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        game.startGame()
        hiddenWord = game.getHiddenWord()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapter = RecyclerAdapter(game)
        _cardBinding = RecyclerAdapter(game)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter

        result = binding.resultView
        points = binding.points
        player = game.getPlayer()
        luckyWheel = binding.luckyWheel
        lives = binding.lifeCount

        binding.guessInputField.setVisibility(View.GONE)
        binding.guessButton.setVisibility(View.GONE)

        binding.spinWheelButton.setOnClickListener(){
            game.spinTheWheel()
            spinningAnimation()
            viewModel.setResultValue("")
            Handler().postDelayed({
                viewModel.setResultValue(game.getResult())
                viewModel.setPointsValue(player!!.getPoints())
                viewModel.setLivesValue(player!!.getLives())
                if (game.getIsValue()){
                    makeGuessView()
                } else {
                    otherFieldView()
                }
            }, 1010)
        }

        binding.guessButton.setOnClickListener(){
            game.getHiddenWord().displayLetterIfTrue(binding.guessInputField.text.toString())
            binding.guessInputField.text.clear()
            if (hiddenWord.ifLetterIsRight()){
                if (game.isGameWon()){
                    findNavController().navigate(R.id.action_heartFragment_to_wonGameFragment)
                }
                player!!.addPoints(hiddenWord.getRightGuesses() * game.getPointsToWin())
                viewModel.setPointsValue(player!!.getPoints())
                (adapter as RecyclerAdapter).notifyDataSetChanged()
                hiddenWord.setLetterIsRight(false)

            } else {
                player!!.loseLife()
                viewModel.setLivesValue(player!!.getLives())
                if (player!!.getLives() == 0)
                    findNavController().navigate(R.id.action_gameFragment_to_lostFragment)
                }

            afterGuessingView()

            }

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

    private fun makeGuessView(){
        binding.guessInputField.setVisibility(View.VISIBLE)
        binding.guessButton.setVisibility(View.VISIBLE)
        binding.spinWheelButton.setVisibility(View.GONE)
        binding.luckyWheel.setVisibility(View.GONE)
    }
    private fun afterGuessingView(){
        binding.spinWheelButton.setVisibility(View.VISIBLE)
        binding.luckyWheel.setVisibility(View.VISIBLE)
        binding.guessButton.setVisibility(View.GONE)
        binding.guessInputField.setVisibility(View.GONE)
        view?.hideKeyboard()

    }

    private fun otherFieldView(){
        binding.guessInputField.setVisibility(View.GONE)
        binding.guessButton.setVisibility(View.GONE)
    }

    override fun onDestroy(){
        super.onDestroy()
    }





}



