package com.example.s205353lykkehjulet.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.s205353lykkehjulet.R
import com.example.s205353lykkehjulet.databinding.FragmentLostGameBinding


class LostGameFragment : Fragment() {

    private var _binding: FragmentLostGameBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLostGameBinding.inflate(inflater, container, false)

        binding.tryAgainButton.setOnClickListener {
            findNavController().navigate(R.id.action_lostGameFragment_to_chooseTopicFRagment) }

        return binding.root
    }

}