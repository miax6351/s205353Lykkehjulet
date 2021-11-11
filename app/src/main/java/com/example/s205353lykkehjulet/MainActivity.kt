package com.example.s205353lykkehjulet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.s205353lykkehjulet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var rightLetter = false
    private val player = Player()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
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