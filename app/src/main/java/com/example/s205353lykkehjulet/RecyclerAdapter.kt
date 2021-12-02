package com.example.s205353lykkehjulet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var titles = Word.getQuestionMarkArray()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
         val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        LinearLayoutManager.HORIZONTAL
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemLetter.text = titles[position].toString()
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    fun getTitles(): ArrayList<Char> {
        return titles
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var itemLetter : TextView

        init {
            itemLetter = itemView.findViewById(R.id.letterView)
        }
    }

    fun setTitles(newArray: ArrayList<Char>){
        titles = newArray
    }



}