package com.example.s205353lykkehjulet

class Player {

    private var lives = 5
    private var loseStatus = false
    private var points = 0

    fun getLives(): Int {
        return lives
    }

    fun loseLife() {
        if (lives > 0){
            lives--
        } else {
            lives = 0
        }


    }

    fun getLoseStatus(): Boolean {
        return loseStatus
    }

    fun getPoints(): Int {
        return points
    }

    fun setPoints(newPoints: Int) {
        points = newPoints;
    }

    fun addPoints(newPoints: Int){
        points += newPoints
    }

}