package com.example.miniproject

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.miniproject.databinding.SingleOrderItemBinding

class ShoppingCartAdapter(private var itemList: ArrayList<Item>): RecyclerView.Adapter<ShoppingCartAdapter.ViewHolder>() {

    private lateinit var binding: SingleOrderItemBinding
    var quantityValue = 0

    inner class ViewHolder(binding: SingleOrderItemBinding): RecyclerView.ViewHolder(binding.root) {
        val itemImage: ImageView = binding.itemImage
        val itemName: TextView = binding.itemName
        val itemPrice: TextView = binding.itemPrice
        val minus: Button = binding.btnMinus
        val plus: Button = binding.btnPlus
        val quantity: TextView = binding.txtquantity
        val remove: ImageView = binding.removeItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = SingleOrderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemDetails = itemList[position]
        holder.itemImage.setImageResource(itemDetails.itemImage)
        holder.itemName.text = itemDetails.itemName
        holder.itemPrice.text = itemDetails.itemPrice
        holder.plus.setOnClickListener {
            quantityValue += 1
            holder.quantity.text = quantityValue.toString()
        }
        holder.minus.setOnClickListener {
            if (quantityValue > 1) {
                quantityValue -= 1
            }
            holder.quantity.text = quantityValue.toString()
        }
        holder.remove.setOnClickListener {
            itemList.remove(itemDetails)
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int {
        return itemList.count()
    }
}