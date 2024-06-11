package com.example.tec

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.tec.databinding.ItemBinding

class WordsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemBinding.bind(view)

    fun bind(item: Datum) {
        binding.tvPalabraEs.text = "Palabra Español: ${item.palabraEs}"
        binding.tvPalabraXiu.text = "Palabra Xiu: ${item.palabraXiu}"
    }
}

