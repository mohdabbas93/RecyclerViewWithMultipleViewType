package com.narbase.recyclerviewwithmultipleviewtype

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.character_info_item.view.*
import kotlinx.android.synthetic.main.quote_item.view.*

class MyAdapter(val myList: List<Model>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val QUOTE_TYPE = 0
    val CHARACTER_INFO_TYPE = 1

    class Quote(view: View) : RecyclerView.ViewHolder(view) {
        val quoteView = view
    }

    class Character(view: View) : RecyclerView.ViewHolder(view) {
        val characterView = view
    }


    override fun getItemViewType(position: Int) = when (myList[position].type) {
        QUOTE_TYPE -> QUOTE_TYPE
        else -> CHARACTER_INFO_TYPE
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is Quote) {
            holder.quoteView.quote.text = myList[position].quote
        } else if (holder is Character) {
            holder.characterView.character_name.text = myList[position].name
            holder.characterView.character_regiment.text = myList[position].regiment
            holder.characterView.character_image.setImageResource(myList[position].image)
        }
    }

    override fun getItemCount() = myList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            when (viewType) {
                QUOTE_TYPE -> Quote(LayoutInflater.from(parent.context)
                        .inflate(R.layout.quote_item, parent, false))
                else -> Character(LayoutInflater.from(parent.context)
                        .inflate(R.layout.character_info_item, parent, false))
            }

}