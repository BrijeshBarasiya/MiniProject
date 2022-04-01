package User

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.miniproject.OrderedItemModelClass
import com.example.miniproject.R

class UserOrderedItemAdapter(
    private val elements: List<OrderedItemModelClass>
): RecyclerView.Adapter<UserOrderedItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserOrderedItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_order_history_items, parent, false)
        return UserOrderedItemHolder(view)
    }

    override fun onBindViewHolder(holder: UserOrderedItemHolder, position: Int) {
        val element: OrderedItemModelClass = elements[position]
        holder.itemName.text = element.itemName
        holder.itemPrice.text = "Price: " + element.itemPrice
        holder.itemQty.text = "Oty: " + element.itemQty
        holder.itemTotal.text = "Total: " + element.itemTotal
    }

    override fun getItemCount(): Int {
        return elements.size
    }
}

class UserOrderedItemHolder(view: View): RecyclerView.ViewHolder(view) {

    val itemName: TextView = view.findViewById(R.id.item_name)
    val itemPrice: TextView = view.findViewById(R.id.item_price)
    val itemQty: TextView = view.findViewById(R.id.item_qty)
    val itemTotal: TextView = view.findViewById(R.id.item_total)

}