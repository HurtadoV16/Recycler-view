package com.example.marvelapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelapp.adapter.RecyclerViewAdapter
import com.example.marvelapp.adapter.RecyclerViewAdapterH
import com.example.marvelapp.data.DataSource
import com.example.marvelapp.databinding.ActivityMainBinding
import com.example.marvelapp.model.Superheroe

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var miRecycler: RecyclerView
    val miAdapter: RecyclerViewAdapter = RecyclerViewAdapter()
    val miAdapterH: RecyclerViewAdapterH = RecyclerViewAdapterH()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cargarRecycler()
        cargarRecyclerH()
    }

    fun cargarRecycler(){
      miRecycler = binding.rvSuperHeroes
      miRecycler.setHasFixedSize(true)
      miRecycler.layoutManager = LinearLayoutManager(this)
      miAdapter.RecyclerViewAdapter(
          DataSource().getSuperHeroes(), this)
      miRecycler.adapter = miAdapter

        miAdapter.setOnItemClickListener(object :
            RecyclerViewAdapter.onItemClickListener{
            override fun onItemClickListener(position: Int) {
                /*Toast.makeText(this@MainActivity,
                    "se selecciono el item: " +
                        "$position",Toast.LENGTH_SHORT).show()*/
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("nombre",
                    DataSource().getSuperHeroes().get(position).nombre)
                intent.putExtra("nombreReal",
                    DataSource().getSuperHeroes().get(position).nombreReal)
                intent.putExtra("publisher",
                    DataSource().getSuperHeroes().get(position).publisher)
                intent.putExtra("imagen",
                    DataSource().getSuperHeroes().get(position).foto)
                startActivity(intent)
                Log.d("nombre heroe",DataSource().getSuperHeroes().get(position).nombre)
            }

        })
    }
    fun cargarRecyclerH(){
        miRecycler = binding.rvsuperheroe2
        miRecycler.setHasFixedSize(true)
        miRecycler.layoutManager = LinearLayoutManager(this)
        miAdapterH.RecyclerViewAdapterH(DataSource().getSuperHeroes(), this)
        miRecycler.adapter = miAdapterH
    }

}