package com.example.s205353lykkehjulet.Model

class Game {

    private var value = Value()
    private var player = Player()
    private var result = ""
    private var pointsToWin = 0
    private var isValue : Boolean = false
    private var gameWon = false
    private lateinit var hiddenWord : HiddenWord


    fun startGame(){
        hiddenWord = HiddenWord()
        hiddenWord.getQuestionMarkArray().clear()
    }

    /**
     * This method defines the outcome of the differens spin fields
     */
    fun spinTheWheel(){
            isValue = false
            val spin = (Math.random() * Field.values().size).toInt()

            val field : Field = Field.values().get(spin)
            setResult(field.toString())

            when (field){
                Field.VALUE -> {
                    pointsToWin = value.getRandomValue()
                    setResult(pointsToWin.toString())
                    isValue = true
                }
                Field.EXTRA_TURN -> {
                    setResult(field.toString())
                    player.addLife()
                }
                Field.MISSED_TURN -> player.loseLife()
                Field.BANKRUPTCY -> {
                    player.setPoints(0)
                }
                Field.DOUBLE_VALUE -> {
                    pointsToWin = value.getRandomValue() * 2
                    setResult(pointsToWin.toString())
                    isValue = true
                }
                Field.TRIPLE_VALUE -> {
                    pointsToWin = value.getRandomValue() * 3
                    setResult(pointsToWin.toString())
                    isValue = true
                }
            }


    }

    fun guessLetter(letter : String){
        hiddenWord.displayLetterIfTrue(letter)
        if (hiddenWord.ifLetterIsRight()){
            player.addPoints(pointsToWin * hiddenWord.getRightGuesses())
        }
    }

    /**
     * This method checks if the game is won based on, whether the guessed word (by the user)
     * is the same word, as the one that was hidden in the beginning of the game
     */
    fun isGameWon() : Boolean{
        var hiddenword = hiddenWord.getHiddenWordArray()
        var guessedword = hiddenWord.getQuestionMarkArray()
        var realGuessedWord = ArrayList<Char>()

        for (i in 0..guessedword.size - 1){
            if (guessedword[i].equals('-')){
                realGuessedWord.add(' ')
            } else {
                realGuessedWord.add(guessedword[i])
            }
        }

        gameWon = realGuessedWord.equals(hiddenword)
        return gameWon
    }


    fun getResult(): String {
        return result
    }

    fun setResult(string : String){
        result = string
    }

    fun getPointsToWin(): Int {
        return pointsToWin
    }

    fun getPlayer(): Player {
        return player
    }

    fun getIsValue(): Boolean {
        return isValue
    }

    fun getHiddenWord(): HiddenWord {
        return hiddenWord
    }

}