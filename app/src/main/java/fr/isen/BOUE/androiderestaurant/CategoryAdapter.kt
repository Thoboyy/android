package fr.isen.BOUE.androiderestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(private val categories: ArrayList<String>) : RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
       val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_cell, parent, false)

        return CategoryHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {

        holder.textView.text = categories[position]
    }

    override fun getItemCount(): Int = categories.size

    class CategoryHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)
    }
}
