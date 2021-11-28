package com.example.s205353lykkehjulet

import kotlin.random.Random

object HiddenWord {

    private var questionMarkArray: ArrayList<Char> = ArrayList()
    private var hiddenWordsArray = arrayOf("Cat","Dog","Rooster","Coca Cola")
    private var word = hiddenWordsArray[(Random.nextInt(0, hiddenWordsArray.size - 1))]
    private var wordArray = word.toList() as ArrayList<Char>
    private var rightGuesses = 0;
    private var letterIsRight : Boolean = false


    fun getHiddenWordArray(): ArrayList<Char> {
        return wordArray
    }

    fun displayLetterIfTrue(guess : String){
        rightGuesses = 0
        letterIsRight = false

        for (i in 0..wordArray.size - 1) {
            if (guess.equals(wordArray[i].toString(),true)){
                getQuestionMarkArray()[i] = wordArray[i]
                letterIsRight = true
                rightGuesses++
            }
        }
        // To ensure you only get points for one letter at a time
        for (i in (wordArray.size - 1) downTo 0){
            if (wordArray[i].equals(getQuestionMarkArray()[i]))
                wordArray[i] = ' '

        }

    }

    fun getQuestionMarkArray(): ArrayList<Char>{

        if (questionMarkArray.isEmpty()){
            for (i in 1..wordArray.size){
                if (wordArray[i - 1].equals(' ')){
                    questionMarkArray.add('-')
                } else {
                    questionMarkArray.add('?')
                }
            }
        }
        return questionMarkArray
    }

    fun getRightGuesses(): Int {
        return rightGuesses
    }

    fun ifLetterIsRight(): Boolean {
        return letterIsRight
    }

    fun setLetterIsRight(value : Boolean){
        letterIsRight = value
    }

}