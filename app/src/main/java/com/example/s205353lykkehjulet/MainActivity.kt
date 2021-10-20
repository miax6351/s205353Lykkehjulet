package com.example.s205353lykkehjulet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import com.example.s205353lykkehjulet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var rightLetter = false
    private val player = Player()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.fragment_word_letter)
        setContentView(R.layout.fragment_heart)
    }

    private fun spinTheWheel(){

        var times = 0
        while (times < 100){
            val spin = (Math.random() * Field.values().size).toInt()
            System.out.println("*******************************************" + spin)
            times++

            val field : Field = Field.values().get(spin)

            when (field){
            Field.VALUE -> println("guess word")
            Field.EXTRA_TURN -> spinTheWheel()
            Field.MISSED_TURN -> break
            Field.BANKRUPTCY -> player.setPoints(0)
            }
        }


    }

}