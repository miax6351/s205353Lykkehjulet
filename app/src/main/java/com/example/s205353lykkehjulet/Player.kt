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
            setLives(lives - 1)
        } else {
            lives = 0
        }
    }

    fun addLife(){
        setLives(lives + 1)
    }

    fun getLoseStatus(): Boolean {
        return loseStatus
    }

    fun getPoints(): Int {
        HiddenWord.setWonScore(points)
        return points
    }

    fun setPoints(newPoints: Int) {
        points = newPoints;
    }

    fun addPoints(newPoints: Int){
        points += newPoints
    }

    private fun setLives(change : Int){
        lives = change
    }

}