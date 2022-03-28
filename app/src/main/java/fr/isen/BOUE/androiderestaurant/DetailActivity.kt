package fr.isen.BOUE.androiderestaurant

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import fr.isen.BOUE.androiderestaurant.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var quantity = 1
        val item = intent.getSerializableExtra(CategoryActivity.DETAILS_KEY) as Items
        binding.titrePlat.text = item.name_fr

        binding.ingrPlat.text = item.ingredients.joinToString(", ", transform = { it.name_fr })

        binding.plus.setOnClickListener{
            quantity++
            Log.i("quantity",quantity.toString())
            display(quantity,quantity*item.prices[0].price.toFloat())

        }
        binding.minus.setOnClickListener{
            if(quantity!=1) {
                quantity--
            }
            display(quantity,quantity*item.prices[0].price.toFloat())
        }
        
        binding.viewSlider.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.viewSlider.adapter = ViewAdapter(this,item.images)

    }

    private fun display(quantity : Int, price : Float){
        binding.itemQuantity.text=quantity.toString()
        binding.btnPrix.text = price.toString()+"€"
    }

}