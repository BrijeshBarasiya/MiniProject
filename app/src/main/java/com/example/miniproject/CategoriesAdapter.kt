package com.example.miniproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.miniproject.databinding.SingleCategoryBinding

class CategoriesAdapter(private var categoryList: ArrayList<Category>): RecyclerView.Adapter<CategoriesAdapter.ViewHolder>()  {

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
        holder.categoryImage.setImageResource(itemDetails.categoryImage)
        holder.categoryName.text = itemDetails.categoryName
    }

    override fun getItemCount(): Int {
        return categoryList.count()
    }

}