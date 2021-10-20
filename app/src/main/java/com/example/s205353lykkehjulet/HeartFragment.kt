package com.example.s205353lykkehjulet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.s205353lykkehjulet.databinding.FragmentHeartBinding


/**
 * A simple [Fragment] subclass.
 * Use the [HeartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HeartFragment : Fragment() {
    private var _binding: FragmentHeartBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHeartBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HeartFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            HeartFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}