package com.example.s205353lykkehjulet.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.s205353lykkehjulet.Model.Game
import com.example.s205353lykkehjulet.R

/**
 * Code implemented based  inspiration from the following video:
 * https://www.youtube.com/watch?v=UCddGYMQJCo
 */

class RecyclerAdapter(game : Game) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    private var titles = game.getHiddenWord().getQuestionMarkArray()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        LinearLayoutManager.HORIZONTAL
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemLetter.text = titles[position].toString()
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