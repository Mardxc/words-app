package com.example.tec

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class WordsAdapter(private val data:List<Datum>) : RecyclerView.Adapter<WordsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return WordsViewHolder(layoutInflater.inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int = data.size


    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }
}