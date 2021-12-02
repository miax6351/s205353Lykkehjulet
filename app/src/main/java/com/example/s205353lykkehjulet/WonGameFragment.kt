package com.example.s205353lykkehjulet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.s205353lykkehjulet.databinding.FragmentWonGameBinding

class WonGameFragment : Fragment() {
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
            findNavController().navigate(R.id.action_wonGameFragment_to_fragment_landing_page) }
        binding.score.setText(binding.score.text.toString() + " " )
        binding.textView2.setText(binding.textView2.text.toString() + " ")

        return binding.root
    }
}