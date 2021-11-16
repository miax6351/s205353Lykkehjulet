package com.example.s205353lykkehjulet

import kotlin.random.Random

class Value {

    private var valueArray = arrayOf(100,200,300,400,500)

    fun getRandomValue(): Int {
        return valueArray[Random.nextInt(0,valueArray.size - 1)]
    }
}