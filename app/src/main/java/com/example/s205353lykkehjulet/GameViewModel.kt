package com.example.s205353lykkehjulet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private val _currentResult = MutableLiveData<String>()
    val currentResult : LiveData<String>
    get() = _currentResult

    private val _currentPoints = MutableLiveData<Int>()
    val currentPoints : LiveData<Int>
        get() = _currentPoints

    private val _currentQuestionMarkArray = MutableLiveData<ArrayList<Char>>()
    val currentQuestionMarkArray : LiveData<ArrayList<Char>>
    get() = _currentQuestionMarkArray

    fun setResultValue(string : String){
        _currentResult.value = string
    }

    fun setQuestionValue(questionMarkArray : ArrayList<Char>){
        _currentQuestionMarkArray.value = questionMarkArray
    }

    fun setPointsValue(points : Int){
        _currentPoints.value = points
    }


}