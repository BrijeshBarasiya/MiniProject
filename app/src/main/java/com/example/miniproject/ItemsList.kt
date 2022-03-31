package com.example.miniproject

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miniproject.databinding.ActivityItemsListBinding

class ItemsList : AppCompatActivity() {
    private lateinit var binding: ActivityItemsListBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerviewAdapte: GridItemsAdapter
    val dataList = ArrayList<ItemsData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items_list)
        binding = ActivityItemsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataList.add(ItemsData("Eraser", "Price : 50.00 ", R.drawable.pen))
        dataList.add(ItemsData("Pen", "Price: 250.00", R.drawable.pen))
        dataList.add(ItemsData("Envelop", "Price: 99.00", R.drawable.pen))
        dataList.add(ItemsData("Eraser", "Price : 50.00 ", R.drawable.pen))
        dataList.add(ItemsData("Pen", "Price: 250.00", R.drawable.pen))
        dataList.add(ItemsData("Envelop", "Price: 99.00", R.drawable.pen))

        recyclerviewAdapte = GridItemsAdapter(this, dataList)
        binding.recyclerview.layoutManager = GridLayoutManager(applicationContext, 2)
        binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.adapter = recyclerviewAdapte
    }

}