package User

import Dashboard.ItemDetails
import Dashboard.OrderDetails
import Dashboard.UserDetails
import Firebase.database
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.miniproject.databinding.UserOrderHistoryBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class OrderHistory : AppCompatActivity() {

    private lateinit var binding: UserOrderHistoryBinding
    private lateinit var arrayList: ArrayList<UserDetails>
    private lateinit var orderList: ArrayList<OrderDetails>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UserOrderHistoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        arrayList = arrayListOf<UserDetails>()
        orderList = arrayListOf<OrderDetails>()
        getData()
    }

    private fun getData() {
        FirebaseDatabase.getInstance().getReference("Details").addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for(userShot in snapshot.children) {
                        val data = userShot.getValue(UserDetails::class.java)
                        orderList = data!!.userOrders!!

                    }
                }
                binding.recylerOrders.adapter = UserOrderHistoryAdapter(orderList)


/*
                val hf: ArrayList<OrderDetails> = ArrayList()
                for (i in 0..10) {
                    val a: OrderDetails = OrderDetails(i+2,"20/03/2022", "Delivered", 852.5f, listOf(
                        ItemDetails(i+3,"Pencil",52,52,852f),
                        ItemDetails(i+4,"Pencil",52,52,852f),
                        ItemDetails(i+5,"Pencil",52,52,852f),
                        ItemDetails(i+6,"Pencil",52,52,852f),
                        ItemDetails(i+7,"Pencil",52,52,852f),
                        ItemDetails(i+8,"Pencil",52,52,852f),
                        ItemDetails(i+9,"Pencil",52,52,852f),
                        ItemDetails(i+10,"Pencil",52,52,852f)
                    ))
                    hf.add(a)
                }
                val ac = UserDetails(12, "hvahjufv", "anvbjab@gmail.com","adhsbgvakvb",hf)
                database.getReference().child("Details").push().setValue(ac)
*/

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@OrderHistory, "HELLO", Toast.LENGTH_LONG).show()
            }

        })
    }

}