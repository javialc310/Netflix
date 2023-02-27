package com.example.netflix

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView

class ViewAdapter(private var titulo:List<String>, private var descripcion:List<String>, private var imagenesList: List<Int>):
RecyclerView.Adapter<ViewAdapter.Pager2ViewHolder>(){

    inner class Pager2ViewHolder(item: View): RecyclerView.ViewHolder(item){
        val itemTitulo = item.findViewById<TextView>(R.id.tituloView)
        val itemDesc= item.findViewById<TextView>(R.id.descripcionView)
        val itemImagen= item.findViewById<ImageView>(R.id.imagenView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.vistas_layout, parent, false))
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewAdapter.Pager2ViewHolder, position: Int) {
        holder.itemTitulo.text=titulo[position]
        holder.itemDesc.text=descripcion[position]

        holder.itemImagen.setImageResource(imagenesList[position])
        holder.itemView.setBackgroundResource(R.color.black)
    }

    override fun getItemCount(): Int {
        return titulo.size
    }

}