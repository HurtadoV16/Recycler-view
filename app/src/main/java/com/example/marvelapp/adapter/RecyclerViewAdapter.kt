package com.example.marvelapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelapp.R
import com.example.marvelapp.model.Superheroe

class RecyclerViewAdapter:
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
     var superheroes: MutableList<Superheroe> = ArrayList()
     lateinit var context: Context
     lateinit var miListener: onItemClickListener


     //Constructor
     fun RecyclerViewAdapter(superheroes: MutableList<Superheroe>,
                         context: Context){
         this.superheroes = superheroes
         this.context = context
     }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_superheroe, parent, false),miListener)
    }

    override fun getItemCount(): Int {
        return superheroes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = superheroes.get(position)
        //holder.bindingAdapterPosition
        holder.bind(item, context)
    }

    class ViewHolder(view: View, listener: onItemClickListener): RecyclerView.ViewHolder(view) {
        val superheroeName = view.findViewById<TextView>(R.id.tvSuperhero)
        val realName = view.findViewById<TextView>(R.id.tvRealName)
        val publiser = view.findViewById<TextView>(R.id.tvPublisher)
        val foto = view.findViewById<ImageView>(R.id.ivAvatar)
        fun bind(superheroe: Superheroe, context: Context){
            superheroeName.text = superheroe.nombre
            realName.text = superheroe.nombreReal
            publiser.text = superheroe.publisher
            foto.loadImage(superheroe.foto)
        }
        fun ImageView.loadImage(url: String){
            Glide.with(context).load(url).into(this)
        }
        init {
            view.setOnClickListener {
                listener.onItemClickListener(bindingAdapterPosition)
            }
        }
    }

    interface onItemClickListener{
        fun onItemClickListener(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        miListener = listener
    }
}


