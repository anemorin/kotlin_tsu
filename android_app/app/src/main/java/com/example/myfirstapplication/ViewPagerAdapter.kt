package com.example.myfirstapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(private val pages : List<DataPage>) : RecyclerView.Adapter<ViewPagerAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        )

    override fun onBindViewHolder(holder: ViewPagerAdapter.MyViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<ImageView>(R.id.imageView).setImageResource(pages[position].image)
            findViewById<TextView>(R.id.textView).text = pages[position].title
            findViewById<TextView>(R.id.textView2).text = pages[position].text
        }
    }



    override fun getItemCount(): Int {
        return pages.size
    }

}