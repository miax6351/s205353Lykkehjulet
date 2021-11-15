package com.example.s205353lykkehjulet

object HiddenWord {

    private var word = ""
    private var questionMarkArray: ArrayList<Char> = ArrayList()
    private var wordArray : ArrayList<Char> = ArrayList()

    fun getHiddenWordArray(): List<Char> {
        return wordArray
    }

    fun displayLetterIfTrue(guess : Char){
        for (i in 0..wordArray.size - 1) {
            if (guess.equals(wordArray[i])){
                questionMarkArray[i] = wordArray[i]
            }
        }

    }

    fun getQuestionMarkArray(): ArrayList<Char>{
        wordArray = word.toList() as ArrayList<Char>
        if (questionMarkArray.isEmpty()){
            wordArray = word.toList() as ArrayList<Char>
            for (i in 1..wordArray.size){
                questionMarkArray.add('?')
            }
        }

        return questionMarkArray
    }

    fun setWord(string : String){
        word = string
    }

}