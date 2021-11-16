package com.example.s205353lykkehjulet

class Game {

    private var player = Player()
    private var result = ""

    fun startGame(){


    }


    fun spinTheWheel(){

        var times = 0
        while (times < 1){
            val spin = (Math.random() * Field.values().size).toInt()
            //System.out.println("*******************************************" + spin)
            times++

            val field : Field = Field.values().get(spin)
            println("inside spin wheel")
            println(field)
            setResult(field.toString())

            when (field){
                Field.VALUE -> println("guess word")
                Field.EXTRA_TURN -> spinTheWheel()
                Field.MISSED_TURN -> break
                Field.BANKRUPTCY -> player.setPoints(0)
            }
        }


    }

    fun getResult(): String {
        return result
    }

    fun setResult(string : String){
        result = string
    }

}