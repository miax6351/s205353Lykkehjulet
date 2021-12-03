package com.example.s205353lykkehjulet.Model


import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.random.Random


class HiddenWord {

    private var questionMarkArray: ArrayList<Char> = ArrayList()
    private var hiddenWordsArray = ArrayList<String>()
    private var word : String
    private var wordArray : ArrayList<Char>
    private var guessedMap = HashMap<Char, Boolean>()
    private var rightGuesses = 0
    private var letterIsRight : Boolean = false
    private var wonScore : Int = 0
    private var guessedLetters = ArrayList<String>()
    private var animalsArray = arrayOf("Cat","Dog","Rooster","Red Panda", "Beaver","Snow Leopard", "Anteater")
    private var softDrinksArray = arrayOf("Coca Cola", "Sprite", "Seven Up", "Miranda", "Jolly Cola")
    private var brandsArray = arrayOf("Louis Vuitton","Gucci","Balenciaga","Supreme", "Off-White")
    private lateinit var topic : String

    init {

        if (ChosenTopics.getAnimals()){
            for (i in 0..animalsArray.size - 1){
                hiddenWordsArray.add(animalsArray.get(i))
            }
        }

        if (ChosenTopics.getBrands()){
            for (i in 0..brandsArray.size - 1){
                hiddenWordsArray.add(brandsArray.get(i))
            }
        }

        if (ChosenTopics.getSoftDrinks()){
            for (i in 0..softDrinksArray.size - 1){
                hiddenWordsArray.add(softDrinksArray.get(i))
            }
        }

        word = hiddenWordsArray[(Random.nextInt(0, hiddenWordsArray.size - 1))]
        wordArray = word.toList() as ArrayList<Char>

        setGuessedArray()

        println(hiddenWordsArray.toString())
    }

    fun getHiddenWordArray(): ArrayList<Char> {
        return wordArray
    }

    fun setGuessedArray(){
        for (i in 0..wordArray.size - 1){
            guessedMap.put(wordArray[i],false)
        }
    }

    fun displayLetterIfTrue(guess : String){
        rightGuesses = 0
        letterIsRight = false

        for (i in 0..wordArray.size - 1) {
            if (guess.equals(wordArray[i].toString(),true)){
                if (!guessedLetters.contains(guess)){
                    getQuestionMarkArray()[i] = wordArray[i]
                    letterIsRight = true
                    rightGuesses++
                    guessedMap.put(wordArray[i],true)
                }
            }
        }
        guessedLetters.add(guess)

    }

    fun getQuestionMarkArray(): ArrayList<Char>{

        if (questionMarkArray.isEmpty()){
            for (i in 1..wordArray.size){
                if (wordArray[i - 1].equals(' ')){
                    questionMarkArray.add('-')
                } else {
                    questionMarkArray.add('?')
                }
            }
        }
        return questionMarkArray
    }

    fun getRightGuesses(): Int {
        return rightGuesses
    }

    fun ifLetterIsRight(): Boolean {
        return letterIsRight
    }

    fun setLetterIsRight(value : Boolean){
        letterIsRight = value
    }

    fun getWord() : String {
        return word
    }

    fun setWonScore(score : Int){
        wonScore = score
    }

    fun getWonScore(): Int {
        return wonScore
    }

    fun getTopic() : String {

    if (animalsArray.contains(word)){
        topic = "Animal"
    } else if (brandsArray.contains(word)){
        topic = "Brand"
    } else if (softDrinksArray.contains(word)){
        topic = "Soft Drink"
    }
        return topic
    }


}