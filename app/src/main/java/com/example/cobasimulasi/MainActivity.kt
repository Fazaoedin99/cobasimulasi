package com.example.cobasimulasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewManager
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var simpan : Button
    private lateinit var hasile: TextView
    private lateinit var hitung: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var txtAlas: TextView
    private lateinit var txtTinggi:TextView
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        simpan = findViewById(R.id.btsimpan)
        hasile = findViewById(R.id.Thasil)
        hitung = findViewById(R.id.bthitung)
        recyclerView = findViewById(R.id.listData)
        txtAlas = findViewById(R.id.txtAlas)
        txtTinggi = findViewById(R.id.txtTinggi)

        val data = mutableListOf<DataHasil>()
        viewManager = LinearLayoutManager(this)
        recyclerAdapter = HasilAdapter(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager

       simpan.setOnClickListener {
           val bilanganA = txtAlas.text.toString()
           val bilanganT = txtTinggi.text.toString()
           val hasil = hasile.text.toString()

           val dataaa = DataHasil(bilanganA,bilanganT,hasil)
           data.add(dataaa)
           recyclerAdapter.notifyDataSetChanged()
       }
       hitung.setOnClickListener {
           val Alas = txtAlas.text.toString().trim()
           val Tinggi = txtTinggi.text.toString().trim()

           var isEmptyFields = false
           when{
               Alas.isEmpty()->{
                   isEmptyFields = true
                   txtAlas.error = "Alas Tidak Boleh Kosong"
               }
               Tinggi.isEmpty()->{
                   isEmptyFields = true
                   txtTinggi.error = "Tinggi Tidak Boleh Kosong"
               }
           }
           if (!isEmptyFields){
               val hasil = 0.5 * Alas.toDouble() * Tinggi.toDouble()
               hasile.text = hasil.toString()+"CM"}
       }
    }
}