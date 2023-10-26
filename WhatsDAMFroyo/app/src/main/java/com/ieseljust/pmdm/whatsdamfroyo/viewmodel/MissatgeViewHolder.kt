package com.ieseljust.pmdm.whatsdamfroyo.viewmodel

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ieseljust.pmdm.whatsdamfroyo.R
import com.ieseljust.pmdm.whatsdamfroyo.model.Missatge
import java.text.SimpleDateFormat
import java.util.Date

class MissatgeViewHolder(itemView: View) :

    RecyclerView.ViewHolder(itemView){
        val text = itemView.findViewById(R.id.msg_text) as TextView
        val temps = itemView.findViewById(R.id.msg_me_timestamp) as TextView


        // Bloc d'inicialitzacio per indicar que serà la pròpia classe
        // qui implemente el mètode `onClick` de l'item


    fun bind(
        missatge: Missatge
    ){
        text.text = missatge.text



        val dateFormat=SimpleDateFormat("HH:mm")
        val horaActual= Date()
        val horaFormatada=dateFormat.format(horaActual)
        temps.text= horaFormatada
    }





}
