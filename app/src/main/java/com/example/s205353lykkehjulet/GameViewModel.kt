package com.example.s205353lykkehjulet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel(){

    private val _currentResult = MutableLiveData<String>()
    val currentResult : LiveData<String>
    get() = _currentResult

    private val _currentPoints = MutableLiveData<Int>()
    val currentPoints : LiveData<Int>
        get() = _currentPoints

    private val _currentLives = MutableLiveData<Int>()
    val currentLives : LiveData<Int>
        get() = _currentLives

    private val _currentQuestionMarkArray = MutableLiveData<MutableList<Char>>()
    val currentQuestionMarkArray : LiveData<MutableList<Char>>
    get() = _currentQuestionMarkArray



    fun setResultValue(string : String){
        _currentResult.value = string
    }

 fun setQuestionMarkValue(questionMarkArray : ArrayList<Char>){
         _currentQuestionMarkArray.value = questionMarkArray
 }

    fun setQuestionValue(char : Char){
        for (i in 0..HiddenWord.getHiddenWordArray().size - 1) {
            _currentQuestionMarkArray.value?.set(i, char)
        }
    }

    fun setPointsValue(points : Int){
        _currentPoints.value = points
    }

    fun setLivesValue(lives : Int){
        _currentLives.value = lives
    }


}
