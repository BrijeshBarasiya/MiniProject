package User

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.miniproject.databinding.UserOrderHistoryBinding
import com.example.miniproject.orderHistoryValue

class OrderHistory : AppCompatActivity() {

    private lateinit var binding: UserOrderHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UserOrderHistoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.recylerOrders.adapter = UserOrderHistoryAdapter(orderHistoryValue)
    }

}