package com.example.s205353lykkehjulet

import android.view.View
import android.widget.Button
import android.widget.EditText

class Game {

    private var value = Value()
    private var player = Player()
    private var result = ""
    private var pointsToWin = 0
    private var isValue : Boolean = false
    private var gameWon = false



    fun spinTheWheel(){
            isValue = false
            val spin = (Math.random() * Field.values().size).toInt()

            val field : Field = Field.values().get(spin)
            setResult(field.toString())
            println(field.toString())

            when (field){
                Field.VALUE -> {
                    pointsToWin = value.getRandomValue()
                    setResult(pointsToWin.toString())
                    isValue = true
                }
                Field.EXTRA_TURN -> {
                    setResult(field.toString())
                    spinTheWheel()
                }
                Field.MISSED_TURN -> println("")
                Field.BANKRUPTCY -> {
                    player.setPoints(0)
                }
            }


    }

    fun guessLetter(letter : String){
        HiddenWord.displayLetterIfTrue(letter)
        if (HiddenWord.ifLetterIsRight()){
            player.addPoints(pointsToWin * HiddenWord.getRightGuesses())
        }
    }

    fun isGameWon() : Boolean{
        var hiddenword = HiddenWord.getHiddenWordArray()
        var guessedword = HiddenWord.getQuestionMarkArray()
        var realGuessedWord = ArrayList<Char>()

        for (i in 0..guessedword.size - 1){
            if (guessedword[i].equals('-')){
                realGuessedWord.add(' ')
            } else {
                realGuessedWord.add(guessedword[i])
            }
        }

        gameWon = realGuessedWord.equals(hiddenword)
        return gameWon
    }


    fun getResult(): String {
        return result
    }

    fun setResult(string : String){
        result = string
    }

    fun getPointsToWin(): Int {
        return pointsToWin
    }

    fun getPlayer(): Player {
        return player
    }

    fun getIsValue(): Boolean {
        return isValue
    }

}