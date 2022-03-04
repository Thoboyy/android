package fr.isen.BOUE.androiderestaurant

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent
import android.util.Log
import fr.isen.BOUE.androiderestaurant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val intent = Intent(this, CategoryActivity::class.java)
        binding.starters.setOnClickListener(){
            val myToast = Toast.makeText(applicationContext,"Entrees",Toast.LENGTH_SHORT)
            myToast.show()
            intent.putExtra("Category","Entrees");
            startActivity(intent)
        }

        binding.dishes.setOnClickListener(){
            val myToast = Toast.makeText(applicationContext,"Plats",Toast.LENGTH_SHORT)
            myToast.show()
            intent.putExtra("Category","Plats");
            startActivity(intent)
        }

        binding.deserts.setOnClickListener(){
            val myToast = Toast.makeText(applicationContext,"Desserts",Toast.LENGTH_SHORT)
            myToast.show()
            intent.putExtra("Category","Desserts");
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HomeActivity", "Activity destroyed")
    }
}