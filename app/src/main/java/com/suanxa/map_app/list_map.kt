package com.suanxa.map_app

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.ColorSpace.Model
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.suanxa.map_app.adapter.listwisata
import com.suanxa.map_app.model.modellistwisata

class list_map : AppCompatActivity() {
    private lateinit var RecyclerViewWisata : RecyclerView
    private lateinit var AdapterWisata : listwisata

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_map)

        //data untuk list
        val menulist = listOf(
            modellistwisata
                ("Bukittinggi, Sumatera Barat",
                "Jam Gadang",
                R.drawable.jam_gadang,
                "Destinasi yang tidak boleh dilewatkan kalau kamu berkunjung ke Bukittinggi pastilah Jam Gadang. Jam di menara berukuran 13×4 meter ini berada di kawasan Taman Sabai Nan Aluih. Berlokasi di taman, Jam Gadang memiliki suasana yang rindang dengan adanya sejumlah pepohonan hijau. Ikon Bukittinggi ini tak pernah sepi dari pengunjung. Mulai dari pagi, siang, sore, hingga malam, kawasan ini sangat digemari oleh wisatawan.",
                -0.3049441760037679,
                100.36948795756079),

            modellistwisata
                ("Bali",
                "Ulun Danu",
                R.drawable.ulun_danu,
                "Bali wisata blabclalsclcablsc",
                -8.275021434769968,
                115.16680193649081),

            modellistwisata
                ("Kabupaten Solok, Sumatera Barat",
                "Puncak Gagoan",
                R.drawable.gambar4,
                "Wisata Puncak Gagoan di Solok",
                -0.6749405,100.5011956),

            modellistwisata
                ("Danau Talang, Sumatera Barat",
                "Danau Talang",
                R.drawable.danau,
                "Wisata Danau Talang, tempat camping yang nyaman dengan pemandangan yang asri dan sejuk",
                -1.0124999,100.6907972),

            modellistwisata
                ("Pulau Pasumpahan, Sumatera Barat",
                "Pasumpahan Island",
                R.drawable.pulau,
                "Pulau Pasumpahan dengan pemandangan laut yang indah serta pasir pantai yang halus",
                -1.1179373,100.3623127)

        )

        //inisialisasi recycleview dan adapter
        RecyclerViewWisata = findViewById(R.id.rvwisata)
RecyclerViewWisata.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        AdapterWisata= listwisata(menulist)
RecyclerViewWisata.adapter = AdapterWisata


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}