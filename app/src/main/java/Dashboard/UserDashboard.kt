package Dashboard

import User.OrderHistory
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.miniproject.Categories
import com.example.miniproject.ItemsList
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
            Intent(this,Categories::class.java).apply {
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