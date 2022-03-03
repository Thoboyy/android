package fr.isen.BOUE.androiderestaurant

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var button1 = findViewById<Button>(R.id.button1)
        var button2 = findViewById<Button>(R.id.button2)
        var button3 = findViewById<Button>(R.id.button3)
        val intent = Intent(this, CategoryActivity::class.java)
        button1.setOnClickListener(){
            val myToast = Toast.makeText(applicationContext,"Entrees",Toast.LENGTH_SHORT)
            myToast.show()
            intent.putExtra("Category","Entrees");
            startActivity(intent)
        }

        button2.setOnClickListener(){
            val myToast = Toast.makeText(applicationContext,"Plats",Toast.LENGTH_SHORT)
            myToast.show()
            intent.putExtra("Category","Plats");
            startActivity(intent)
        }

        button3.setOnClickListener(){
            val myToast = Toast.makeText(applicationContext,"Desserts",Toast.LENGTH_SHORT)
            myToast.show()
            intent.putExtra("Category","Desserts");
            startActivity(intent)
        }
    }

}