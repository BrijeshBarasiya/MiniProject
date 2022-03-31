package com.example.miniproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.miniproject.databinding.ActivityCategoriesBinding


class Categories : AppCompatActivity() {

    private lateinit var binding: ActivityCategoriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getCategoryList()
    }

    private fun getCategoryList() {
        val cartRecyclerView = binding.categoryRecyclerView
        val layoutManager = GridLayoutManager(this, 2)
        cartRecyclerView.layoutManager = layoutManager
        cartRecyclerView.adapter = CategoriesAdapter(Data.categoryData())
    }

}