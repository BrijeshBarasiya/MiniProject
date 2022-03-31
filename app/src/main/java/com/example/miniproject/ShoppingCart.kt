package com.example.miniproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.miniproject.databinding.ActivityShoppingCartBinding

class ShoppingCart : AppCompatActivity() {

    private lateinit var binding: ActivityShoppingCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getItemList()
        binding.placeOrder.setOnClickListener {
            val intent = Intent(this, Categories::class.java)
            startActivity(intent)
        }
    }

    private fun getItemList() {
        val cartRecyclerView = binding.shoppingCartRecyclerView
        cartRecyclerView.adapter = ShoppingCartAdapter(Data.orderedItemData())
    }
}