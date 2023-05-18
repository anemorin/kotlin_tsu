package com.example.myfirstapplication.Dictionary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapplication.R

class MeaningAdapter(word: Word): RecyclerView.Adapter<MeaningAdapter.MeaningViewHolder>() {
    val definitions = word.meanings[0].definitions

    class MeaningViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        private val textViewMeaning: TextView = view.findViewById(R.id.dict_meaning)
        private val textViewExample: TextView = view.findViewById(R.id.dict_example)
        fun onBind(definition: String, example: String?) {
            textViewMeaning.text = definition
            textViewExample.text = "Example: $example"  }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeaningViewHolder =
        MeaningViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_meaning, parent, false))


    override fun getItemCount(): Int = definitions.size

    override fun onBindViewHolder(holder: MeaningViewHolder, position: Int) {
        holder.onBind(definitions[position].definition, definitions[position].example )
    }
}