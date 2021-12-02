package com.example.s205353lykkehjulet

object ChosenTopics {

    private var animals : Boolean = true
    private var brands : Boolean = true
    private var softDrinks : Boolean = true

    fun setAnimals(status : Boolean){
        animals = status
    }

    fun setBrands(status : Boolean){
        brands = status
    }

    fun setSoftDrinks(status : Boolean){
        softDrinks = status
    }

    fun getAnimals(): Boolean {
        return animals
    }

    fun getBrands(): Boolean {
        return brands
    }

    fun getSoftDrinks(): Boolean {
        return softDrinks
    }

}