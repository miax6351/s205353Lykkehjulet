package com.example.s205353lykkehjulet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private val _currentResult = MutableLiveData<String>()
    val currentResult : LiveData<String>
    get() = _currentResult

    fun setValue(string : String){
        _currentResult.value = string
    }


}