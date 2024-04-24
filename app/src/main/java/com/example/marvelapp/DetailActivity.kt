package com.example.marvelapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.marvelapp.databinding.ActivityDetailBinding
import com.example.marvelapp.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cargarDetalle()
    }

    fun cargarDetalle(){
        var nombre: String = intent.getStringExtra("nombre").toString()
        binding.tvSuperhero.text = nombre
        var nombreReal: String = intent.getStringExtra("nombreReal").toString()
        binding.tvRealName.text = nombreReal
        var publisher: String = intent.getStringExtra("publisher").toString()
        binding.tvPublisher.text = publisher
        var foto: String = intent.getStringExtra("foto").toString()
        //binding.ivAvatar = foto
    }
}