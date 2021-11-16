package com.example.s205353lykkehjulet

class Game {

    private var value = Value()
    private var player = Player()
    private var result = ""
    private var pointsToWin = 0

    fun startGame(){


    }


    fun spinTheWheel(){

       // while (player.getLives() > 0){
            val spin = (Math.random() * Field.values().size).toInt()

            val field : Field = Field.values().get(spin)
            setResult(field.toString())
            println(field.toString())

            when (field){
                Field.VALUE -> {
                    pointsToWin = value.getRandomValue()
                    setResult(pointsToWin.toString())
                    player.addPoints(pointsToWin * HiddenWord.getRightGuesses())
                }
                Field.EXTRA_TURN -> {
                    setResult(field.toString())
                    spinTheWheel()
                }
                Field.MISSED_TURN -> println("")
                Field.BANKRUPTCY -> {
                    player.setPoints(0)
                }
            }
       // }


    }

    fun getResult(): String {
        return result
    }

    fun setResult(string : String){
        result = string
    }

}