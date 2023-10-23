package com.ieseljust.pmdm.whatsdamfroyo

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.util.Date

class MissatgeViewHolder(itemView: View, val context: Context) :

    View.OnClickListener,
    RecyclerView.ViewHolder(itemView){
        val text = itemView.findViewById(R.id.msg_text) as TextView
        val temps = itemView.findViewById(R.id.msg_me_timestamp) as TextView


        // Bloc d'inicialitzacio per indicar que serà la pròpia classe
        // qui implemente el mètode `onClick` de l'item

        init {
            itemView.setOnClickListener(this)
        }
    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(
        missatge: Missatge,
        eventListener: (Missatge, View) -> Boolean){
        text.text



        val dateFormat=SimpleDateFormat("HH:mm")
        val horaActual= Date()
        val horaFormatada=dateFormat.format(horaActual)
        temps.text= horaFormatada
    }



    override fun onClick(item: View?) {
        Toast.makeText(context, "Has fet click sobre ${text.text}", Toast.LENGTH_SHORT).show()
        // De moment la mostrem al Log
        Log.d("Metode onClick", "Has fet click sobre ${text.text}")

    }


}
