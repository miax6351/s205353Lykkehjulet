package com.example.s205353lykkehjulet


class HiddenWord(word: String) {


    private var questionMarkArray: ArrayList<Char> = ArrayList()
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

    fun getQuestionMarkArray(): ArrayList<Char>{
        //questionMarkArray = ArrayList<Char>(wordArray.size)
        for (i in 1..wordArray.size){
            questionMarkArray.add('?')
        }
        return questionMarkArray
    }


}