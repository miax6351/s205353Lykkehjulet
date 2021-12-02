package com.example.s205353lykkehjulet

object Word {

    private var questionMarkArray: ArrayList<Char> = ArrayList()

    fun getQuestionMarkArray(): ArrayList<Char> {
        return questionMarkArray
    }

    fun setQuestionMarkArray(array : ArrayList<Char>){
        questionMarkArray = array
    }
}