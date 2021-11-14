package com.example.s205353lykkehjulet

class HiddenWord {

    var hiddenWord = "Giraffe"
    private var hiddenWordArray = hiddenWord.chunked(1)

    fun String.chunked(size: Int): List<String> {
        val nChunks = length / size
        return (0 until nChunks).map { substring(it * size, (it + 1) * size) }
    }

    fun getHiddenWordArray(): List<String> {
        return hiddenWordArray
    }


}