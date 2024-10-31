package com.suanxa.map_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class detail_wisata: AppCompatActivity() {
    private lateinit var detail_lokasi : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_wisata)

        val nama = intent.getStringExtra("namawisata")
        val image = intent.getIntExtra("image",0)
        val deskripsi = intent.getStringExtra("deskripsi")
        val latitude = intent.getDoubleExtra("latitude",0.0)
        val longitude = intent.getDoubleExtra("longitude",0.0)

        val txtnama = findViewById<TextView>(R.id.nama)
        val imgwisata = findViewById<ImageView>(R.id.gambar)
        val des_wisata = findViewById<TextView>(R.id.deskripsi)

        txtnama.text = nama
        imgwisata.setImageResource(image)
        des_wisata.text = deskripsi

        detail_lokasi = findViewById(R.id.btn_lokasi)

        detail_lokasi.setOnClickListener(){
            val intent = Intent(this,MapsActivity::class.java).apply{
                putExtra("latitude", latitude)
                putExtra("longitude", longitude)
                putExtra("namawisata",nama)
            }
            startActivity(intent)

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}