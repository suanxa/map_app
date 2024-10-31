package com.suanxa.map_app.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.suanxa.map_app.R
import com.suanxa.map_app.detail_wisata
import com.suanxa.map_app.model.modellistwisata


class listwisata(
    val itemListDoctors: List<modellistwisata>
): RecyclerView.Adapter<listwisata.MyviewHolder>() {

    class MyviewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var txtNama : TextView = itemView.findViewById(R.id.txtNamawisata)
        var imgwisata : ImageView = itemView.findViewById(R.id.imgwisata)
        var txtlokasi : TextView = itemView.findViewById(R.id.txtlokasi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_wisata,parent,false)
        return MyviewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemListDoctors.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        val currentItem = itemListDoctors[position]
        holder.txtNama.setText(currentItem.namawisata)
        holder.imgwisata.setImageResource(currentItem.image)
        holder.txtlokasi.setText(currentItem.lokasi)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, detail_wisata::class.java).apply {

                putExtra("image", currentItem.image)
                putExtra("lokasi", currentItem.lokasi)
                putExtra("namawisata", currentItem.namawisata)
                putExtra("deskripsi", currentItem.deskripsi)
                putExtra("latitude",currentItem.latitude)
                putExtra("longitude",currentItem.longitude)
            }
                context.startActivity(intent)
        }
    }
}