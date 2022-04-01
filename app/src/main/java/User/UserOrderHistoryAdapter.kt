package User

import Dashboard.OrderDetails
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.miniproject.R

class UserOrderHistoryAdapter(
    private val elements: ArrayList<OrderDetails>
): RecyclerView.Adapter<UserOrderHistoryHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserOrderHistoryHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_order_history_orders, parent, false)
        return UserOrderHistoryHolder(view)
    }

    override fun onBindViewHolder(holder: UserOrderHistoryHolder, position: Int) {
        val element: OrderDetails = elements[position]
        holder.orderId.text = "Order ID: " + element.orderID.toString()
        holder.orderStatus.text = element.orderStatus
        holder.orderTotal.text = "TOTAL: " + element.orderTotal
        holder.items.adapter = element.orderItems?.let { UserOrderedItemAdapter(it) }
    }

    override fun getItemCount(): Int {
        return elements.size
    }

}

class UserOrderHistoryHolder(view: View): RecyclerView.ViewHolder(view) {

    val orderId: TextView = view.findViewById(R.id.order_id)
    val orderStatus: TextView = view.findViewById(R.id.order_date_status)
    val orderTotal: TextView = view.findViewById(R.id.order_total)
    val items: RecyclerView = view.findViewById(R.id.recyler_items)

}