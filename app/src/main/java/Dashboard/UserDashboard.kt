package Dashboard

import Firebase.database
import User.OrderHistory
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.miniproject.Categories
import com.example.miniproject.ShoppingCart
import com.example.miniproject.databinding.DeshboardUserDeshboardBinding


class UserDashboard : AppCompatActivity() {

    private lateinit var binding: DeshboardUserDeshboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DeshboardUserDeshboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.clkCreateOrder.setOnClickListener {
            Intent(this, Categories::class.java).apply {
                startActivity(this)
            }
        }

        binding.clkCart.setOnClickListener {
            Intent(this,ShoppingCart::class.java).apply {
                startActivity(this)
            }
        }

        binding.clkOrderHistory.setOnClickListener {
            Intent(this,OrderHistory::class.java).apply {
                startActivity(this)
            }
        }
    }

}