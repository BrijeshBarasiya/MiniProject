package com.example.miniproject

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.miniproject.databinding.ActivityCategoriesBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class Categories : AppCompatActivity() {

    private lateinit var binding: ActivityCategoriesBinding
    private lateinit var databaseReference: DatabaseReference
    private lateinit var categoryList: ArrayList<Catdata>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getCategoryList()
    }

    private fun getCategoryList() {
        databaseReference = FirebaseDatabase.getInstance().getReference("Categories")
        val cartRecyclerView = binding.categoryRecyclerView
        val layoutManager = GridLayoutManager(this, 2)
        cartRecyclerView.layoutManager = layoutManager
        cartRecyclerView.setHasFixedSize(true)
        categoryList = arrayListOf<Catdata>()
        databaseReference.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (userdata in snapshot.children) {
                        val user = userdata.getValue(Catdata::class.java)
                        if (user != null) {
                            categoryList.add(user)
                        }
                    }
                }
                 cartRecyclerView.adapter = CategoriesAdapter(this@Categories, categoryList)
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, error.message, Toast.LENGTH_LONG).show()
            }

        })
    }

}