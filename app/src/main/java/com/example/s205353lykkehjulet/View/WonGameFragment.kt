package com.example.s205353lykkehjulet.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.s205353lykkehjulet.Model.HiddenWord
import com.example.s205353lykkehjulet.R
import com.example.s205353lykkehjulet.ViewModel.GameViewModel
import com.example.s205353lykkehjulet.databinding.FragmentWonGameBinding

class WonGameFragment(hiddenWord: HiddenWord) : Fragment() {
    private var _binding: FragmentWonGameBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentWonGameBinding.inflate(inflater, container, false)

        binding.tryAgainButton.setOnClickListener {
            findNavController().navigate(R.id.action_wonGameFragment_to_chooseTopicFRagment) }
        binding.textView2.setText(binding.textView2.text.toString())

        return binding.root
    }
}