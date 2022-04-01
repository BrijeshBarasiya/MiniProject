package Admin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.miniproject.databinding.AdminNewItemBinding
import com.example.miniproject.itemDataValues
import com.squareup.picasso.Picasso

class NewItem : AppCompatActivity() {

    private lateinit var binding: AdminNewItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AdminNewItemBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.recylerItems.adapter = AdminItemAdapter(itemDataValues)
    }

}