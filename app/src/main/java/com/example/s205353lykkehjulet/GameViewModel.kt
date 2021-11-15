package com.example.s205353lykkehjulet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private val _currentResult = MutableLiveData<String>()
    val currentResult : LiveData<String>
    get() = _currentResult
    private val _currentQuestionMarkArray = MutableLiveData<ArrayList<Char>>()
    val currentQuestionMarkArray : LiveData<ArrayList<Char>>
    get() = _currentQuestionMarkArray

    fun setValue(string : String){
        _currentResult.value = string
    }

    fun setValue(questionMarkArray : ArrayList<Char>){
        _currentQuestionMarkArray.value = questionMarkArray
    }


}