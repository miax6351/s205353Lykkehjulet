package com.example.s205353lykkehjulet


import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.random.Random


object HiddenWord {

    private var questionMarkArray: ArrayList<Char> = ArrayList()
    private var hiddenWordsArray = arrayOf("Cat","Dog","Rooster","Coca Cola")
    private var word = hiddenWordsArray[(Random.nextInt(0, hiddenWordsArray.size - 1))]
    private var wordArray = word.toList() as ArrayList<Char>
    private var guessedMap = HashMap<Char, Boolean>()
    private var rightGuesses = 0;
    private var letterIsRight : Boolean = false


    init {
        setGuessedArray()
    }

    fun getHiddenWordArray(): ArrayList<Char> {
        return wordArray
    }

    fun setGuessedArray(){
        for (i in 0..wordArray.size - 1){
            guessedMap.put(wordArray[i],false)
        }
    }

    fun displayLetterIfTrue(guess : String){
        rightGuesses = 0
        letterIsRight = false

        for (i in 0..wordArray.size - 1) {
            if (guess.equals(wordArray[i].toString(),true)){
                if (!guessedMap.getValue(wordArray[i])){
                    getQuestionMarkArray()[i] = wordArray[i]
                    letterIsRight = true
                    rightGuesses++
                    guessedMap.put(wordArray[i],true)
                }
            }
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