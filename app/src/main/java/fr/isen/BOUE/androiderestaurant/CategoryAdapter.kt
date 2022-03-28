package fr.isen.BOUE.androiderestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.AdapterView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.reflect.TypeToken.get
import com.squareup.picasso.Picasso
import java.lang.reflect.Array.get
import java.nio.file.Paths.get

class CategoryAdapter(val items: List<Items>, val mListener: (Items) -> Unit) : RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.category_cell, parent, false)

        return CategoryHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        val menu = items [position]
        holder.dishTitre.text = menu.name_fr
        holder.dishPrix.text = menu.prices[0].price + "€"

        Picasso.get().load(menu.images[0].ifEmpty { null }).error(R.drawable.donnut).into(holder.dishPhoto)

        holder.itemView.setOnClickListener{
            mListener.invoke(menu)
        }
    }

    override fun getItemCount(): Int = items.size

    class CategoryHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dishTitre: TextView = view.findViewById(R.id.dishTitle)
        val dishPrix: TextView = view.findViewById(R.id.dishPrice)
        val dishPhoto: ImageView = view.findViewById(R.id.dishImage)
    }
}
