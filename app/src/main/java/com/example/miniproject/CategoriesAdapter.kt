package com.example.miniproject

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.miniproject.databinding.SingleCategoryBinding
import com.squareup.picasso.Picasso


class CategoriesAdapter(private var context: Context, private var categoryList: ArrayList<Catdata>): RecyclerView.Adapter<CategoriesAdapter.ViewHolder>()  {

    private lateinit var binding: SingleCategoryBinding

    inner class ViewHolder(binding: SingleCategoryBinding): RecyclerView.ViewHolder(binding.root) {
        val categoryImage = binding.categoryImage
        var categoryName = binding.categoryTitle
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesAdapter.ViewHolder {
        binding = SingleCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoriesAdapter.ViewHolder, position: Int) {
        val itemDetails = categoryList[position]
        Picasso.get().load(itemDetails.cimage.toString()).into(holder.categoryImage)
        Log.d("Image", itemDetails.cimage.toString())
        holder.categoryName.text = itemDetails.cname
    }

    override fun getItemCount(): Int {
        return categoryList.count()
    }

}