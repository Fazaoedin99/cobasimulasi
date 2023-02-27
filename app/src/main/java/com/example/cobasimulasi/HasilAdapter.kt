package com.example.cobasimulasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HasilAdapter (private val dataset: MutableList<DataHasil>):
  RecyclerView.Adapter<HasilAdapter.HasilHolder>() {
    class HasilHolder (view: View):RecyclerView.ViewHolder(view){
    val bilalas = view.findViewById<TextView>(R.id.bilAlas)
        val biltinggi = view.findViewById<TextView>(R.id.biltinggi)
        val bilHasil = view.findViewById<TextView>(R.id.Thasil)
        val hapus = view.findViewById<Button>(R.id.bthps)
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HasilHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_hasil_adapter,parent,false
        )
        return HasilHolder(view)
    }

    override fun onBindViewHolder(holder: HasilHolder, position: Int) {
        holder.bilalas.text = dataset[position].bilanganAlas
        holder.biltinggi.text = dataset[position].bilanganTinggi
        holder.bilHasil.text = dataset[position].Hasil
        holder.hapus.setOnClickListener {
            dataset.removeAt(position)
            notifyItemRangeRemoved(position,dataset.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = dataset.size
}