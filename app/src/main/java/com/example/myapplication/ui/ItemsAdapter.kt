package com.example.myapplication.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.VendorDetails
import com.squareup.picasso.Picasso

class ItemsAdapter(
    private val context: Context,
    private var items: List<VendorDetails.Data.VendorsItem.Item>
) :
    RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ItemViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {

        fun bind(item: VendorDetails.Data.VendorsItem.Item) {
            view.findViewById<TextView>(R.id.txtTitle).text = item.name
            view.findViewById<TextView>(R.id.txtDesc).text = item.description
            view.findViewById<ImageView>(R.id.img).clipToOutline = true
            Picasso.get()
                .load(item.icon)
                .into(view.findViewById<ImageView>(R.id.img))
        }
    }
}