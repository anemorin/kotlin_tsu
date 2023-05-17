package com.example.myfirstapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class MeaningAdapter(word:Word): RecyclerView.Adapter<MeaningAdapter.MeaningViewHolder>() {
    val defitions = word.meanings[0].definitions

    class MeaningViewHolder(val view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeaningViewHolder =
        MeaningViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_meaning, parent, false))


    override fun getItemCount(): Int = defitions.size

    override fun onBindViewHolder(holder: MeaningViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.dict_meaning).text = defitions[position].defition
            findViewById<TextView>(R.id.dict_example).text = defitions[position].example
        }
    }
}