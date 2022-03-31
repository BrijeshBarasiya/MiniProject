package com.example.miniproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GridItemsAdapter(var context: Context, private val items: ArrayList<ItemsData>): RecyclerView.Adapter<GridItemsAdapter.ViewHolder>() {
    class ViewHolder(itemsview: View): RecyclerView.ViewHolder(itemsview)    {
        var image: ImageView
        var title: TextView
        var desc: TextView
        init {
            image = itemsview.findViewById(R.id.item_image)
            title = itemsview.findViewById(R.id.title)
            desc = itemsview.findViewById(R.id.description)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_layout,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = items[position]
        holder.title.text = data.title
        holder.desc.text = data.desc
        holder.image.setImageResource(data.image)
    }

    override fun getItemCount() = items.size
}