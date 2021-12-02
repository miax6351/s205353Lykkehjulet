package com.example.s205353lykkehjulet.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TopicsViewModel : ViewModel() {
    private val _currentTopic = MutableLiveData<String>()
    val currentTopic : LiveData<String>
        get() = _currentTopic



    fun setTopic(topic : String){
        _currentTopic.value = topic
    }
}