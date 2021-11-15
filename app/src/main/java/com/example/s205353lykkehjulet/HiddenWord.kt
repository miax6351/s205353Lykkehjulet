package com.example.s205353lykkehjulet


class HiddenWord(word: String) {


    private lateinit var questionMarkArray: Array<Char>
    private var wordArray = word.toList()


    fun getHiddenWordArray(): List<Char> {
        return wordArray
    }

    fun displayLetterIfTrue(guess : Char){
        for (i in 0..wordArray.size) {
            if (guess.equals(wordArray[i])){
                questionMarkArray[i] = wordArray[i]
            }
        }

    }

    fun getQuestionMarkArray(): Array<Char>{
        for (i in 1..wordArray.size){
            questionMarkArray[i] = '?'
        }
        return questionMarkArray
    }


}