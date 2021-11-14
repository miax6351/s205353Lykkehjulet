package com.example.s205353lykkehjulet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var hiddenWord = HiddenWord()

    private var titles = hiddenWord.getHiddenWordArray()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
         val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        LinearLayoutManager.HORIZONTAL
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemLetter.text = titles[position]
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var itemLetter : TextView

        init {
            itemLetter = itemView.findViewById(R.id.letterView)
        }
    }

}