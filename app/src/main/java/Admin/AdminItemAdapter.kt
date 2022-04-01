package Admin
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.miniproject.ItemModelClass
import com.example.miniproject.R
import com.squareup.picasso.Picasso

class AdminItemAdapter(
    private val elements: List<ItemModelClass>
): RecyclerView.Adapter<AdminItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.admin_items, parent, false)
        return AdminItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdminItemViewHolder, position: Int) {
        val element: ItemModelClass = elements[position]
        holder.itemName.text = element.itemName
        val price = "RS: ${element.itemPrice}"
        holder.itemPrice.text = price
        Picasso.get().load(element.itemImage).into(holder.itemImage)
        holder.itemEdit.setOnClickListener {
            Toast.makeText(holder.itemEdit.context,"${element.itemImage}",Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return elements.size
    }

}

class AdminItemViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val itemImage: ImageView = view.findViewById(R.id.imv_image)
    val itemName: TextView = view.findViewById(R.id.item_name)
    val itemPrice: TextView = view.findViewById(R.id.item_price)
    val itemEdit: ImageView = view.findViewById(R.id.btn_edit)

}