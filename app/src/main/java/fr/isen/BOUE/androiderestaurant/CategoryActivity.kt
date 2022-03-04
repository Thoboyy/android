package fr.isen.BOUE.androiderestaurant

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import fr.isen.BOUE.androiderestaurant.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val array_starters = resources.getStringArray(R.array.starters_array)
        val array_dishes = resources.getStringArray(R.array.dishes_array)
        val array_deserts = resources.getStringArray(R.array.deserts_array)
        binding.dishList.text = intent.getStringExtra("Category")
        when (binding.dishList.text) {
            "Entrees" -> print(array_starters)
            "Plats" -> print(array_dishes)
            "Desserts" -> print(array_deserts)
            else -> { // Note the block
                print("non")
            }
        }

        // this creates a vertical layout Manager
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<String>()


        // This will pass the ArrayList to our Adapter
        val adapter = CategoryAdapter(data)

        // Setting the Adapter with the recyclerview
        binding.recyclerview.adapter = adapter
    }
}