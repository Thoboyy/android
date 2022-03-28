package fr.isen.BOUE.androiderestaurant

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import fr.isen.BOUE.androiderestaurant.databinding.ActivityCategoryBinding
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject
import com.google.gson.Gson
import android.util.Log
import com.android.volley.toolbox.JsonObjectRequest


class CategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var titre = intent.getStringExtra("Category") ?: ""
        binding.dishList.text = titre
        binding.recyclerview.adapter = CategoryAdapter(arrayListOf()) {}

        loadItemsFromServer(titre)
    }

    private fun loadItemsFromServer(Category: String) {
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val obj = JSONObject()
        obj.put("id_shop", "1")
        val queue = Volley.newRequestQueue(this@CategoryActivity)

        val jsonObjectRequest = JsonObjectRequest(Request.Method.POST, url, obj,
            { response ->
                Log.d("Response", "$response")
                Log.d("CategoryActivity", "Api call success")
                val menu = Gson().fromJson(response.toString(), Details::class.java)
                val items =
                    menu.data.firstOrNull { it.name_fr == Category }?.items ?: arrayListOf()
                val adapter = CategoryAdapter(items) {
                    val intent = Intent(this@CategoryActivity, DetailActivity::class.java)
                    intent.putExtra(DETAILS_KEY, it)
                    startActivity(intent)
                }

                binding.recyclerview.adapter = adapter
                binding.recyclerview.layoutManager = LinearLayoutManager(this)
            },
            { error ->

                Log.d("CategoryActivity", "Api call failed")
            }
        )
        queue.add(jsonObjectRequest)
    }

    companion object {
        const val DETAILS_KEY = "Category"
    }
}