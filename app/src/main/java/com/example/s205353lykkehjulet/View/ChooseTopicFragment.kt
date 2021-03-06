package com.example.s205353lykkehjulet.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.s205353lykkehjulet.Model.ChosenTopics
import com.example.s205353lykkehjulet.R
import com.example.s205353lykkehjulet.databinding.FragmentChooseTopicBinding


class ChooseTopicFragment : Fragment() {

    private var _binding: FragmentChooseTopicBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentChooseTopicBinding.inflate(inflater, container, false)
        binding.start.setOnClickListener {
            findNavController().navigate(R.id.action_chooseTopicFRagment_to_gameFragment) }

        binding.animals.setOnCheckedChangeListener({ button , isChecked ->
            if (isChecked) ChosenTopics.setAnimals(true) else ChosenTopics.setAnimals(false)
        })

        binding.brands.setOnCheckedChangeListener({ button , isChecked ->
            if (isChecked) ChosenTopics.setBrands(true) else ChosenTopics.setBrands(false)
        })

        binding.softDrinks.setOnCheckedChangeListener({ button , isChecked ->
            if (isChecked) ChosenTopics.setSoftDrinks(true) else ChosenTopics.setSoftDrinks(false)
        })

        return binding.root
    }

}