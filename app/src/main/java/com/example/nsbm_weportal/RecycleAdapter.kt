package com.example.nsbm_weportal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleAdapter:RecyclerView.Adapter<RecycleAdapter.ViewHolder>() {
    private var titles= arrayOf("Module1","Module2")
    private var details= arrayOf("Module1 details ","Module2 Details ")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleAdapter.ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecycleAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text=titles[position]
        holder.itemDetail.text=details[position]
    }

    override fun getItemCount(): Int {
        return titles.size
    }
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {

        var itemTitle:TextView
        var itemDetail:TextView
        init {

            itemTitle=itemView.findViewById(R.id.item_title)
            itemDetail=itemView.findViewById(R.id.item_detail)
        }
    }
}