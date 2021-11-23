package com.example.s205353lykkehjulet

object HiddenWord {

    private var questionMarkArray: ArrayList<Char> = ArrayList()
    private var hiddenWordsArray = arrayOf("Cat","Dog","Rooster","Coca Cola")
    private var word = hiddenWordsArray[3]
    private var wordArray = word.toList() as ArrayList<Char>
    private var rightGuesses = 0;
    private var letterIsRight : Boolean = false


    fun getHiddenWordArray(): List<Char> {
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