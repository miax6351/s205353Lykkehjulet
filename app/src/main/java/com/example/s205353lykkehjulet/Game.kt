package com.example.s205353lykkehjulet

class Game {

    private var player = Player()

    fun spinTheWheel(){

        var times = 0
        while (times < 100){
            val spin = (Math.random() * Field.values().size).toInt()
            System.out.println("*******************************************" + spin)
            times++

            val field : Field = Field.values().get(spin)

            when (field){
                Field.VALUE -> println("guess word")
                Field.EXTRA_TURN -> spinTheWheel()
                Field.MISSED_TURN -> break
                Field.BANKRUPTCY -> player.setPoints(0)
            }
        }


    }
}