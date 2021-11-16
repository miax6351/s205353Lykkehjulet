package com.example.s205353lykkehjulet

object HiddenWord {

    private var questionMarkArray: ArrayList<Char> = ArrayList()
    private var hiddenWordsArray = arrayOf("Cat","Dog","Rooster")
    private var word = hiddenWordsArray[1]
    private var wordArray = word.toList() as ArrayList<Char>
    private var rightGuesses = 0;


    fun getHiddenWordArray(): List<Char> {
        return wordArray
    }

    fun displayLetterIfTrue(guess : String){
        rightGuesses = 0
        for (i in 0..wordArray.size - 1) {
            if (guess.equals(wordArray[i].toString(),true)){
                getQuestionMarkArray()[i] = wordArray[i]
                rightGuesses++
            }
        }

    }

    fun getQuestionMarkArray(): ArrayList<Char>{

        if (questionMarkArray.isEmpty()){
            for (i in 1..wordArray.size){
                questionMarkArray.add('?')
            }
        }
        return questionMarkArray
    }

    fun getRightGuesses(): Int {
        return rightGuesses
    }

}