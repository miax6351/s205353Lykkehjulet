package com.example.s205353lykkehjulet.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.s205353lykkehjulet.Model.Player
import com.example.s205353lykkehjulet.R

class HeartRecyclerAdapter(player : Player) : RecyclerView.Adapter<HeartRecyclerAdapter.ViewHolder>() {

    private var hearts = player.getLives()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_heart_layout,parent,false)
        LinearLayoutManager.HORIZONTAL
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return hearts
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var item : ImageView

        init {
            item = itemView.findViewById(R.id.heartImageView)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.itemLetter.text = titles[position].toString()
    }


}