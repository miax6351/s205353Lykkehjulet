package com.example.s205353lykkehjulet

import android.widget.TextView

class Game {


    private var guess = 'A'
    private var guessedWord = arrayOf("?","?","?")
    private lateinit var hiddenWord : HiddenWord
    private var player = Player()
    private var hiddenWordsArray = arrayOf(HiddenWord("Dog"),
        HiddenWord("Cat"),HiddenWord("Lion"), HiddenWord("Rooster"), HiddenWord
            ("Rabbit")
    )
    private var result = ""

    fun startGame(){

        hiddenWord = hiddenWordsArray.iterator().next()

        while (player.getLives() > 0){
            hiddenWord.displayLetterIfTrue('?')
        }

    }


    fun spinTheWheel(){

        var times = 0
        while (times < 100){
            val spin = (Math.random() * Field.values().size).toInt()
            System.out.println("*******************************************" + spin)
            times++

            val field : Field = Field.values().get(spin)
            setResult(field.toString())

            when (field){
                Field.VALUE -> println("guess word")
                Field.EXTRA_TURN -> spinTheWheel()
                Field.MISSED_TURN -> break
                Field.BANKRUPTCY -> player.setPoints(0)
            }
        }


    }

    fun getResult(): String {
        return result
    }

    fun setResult(string : String){
        result = string
    }

}