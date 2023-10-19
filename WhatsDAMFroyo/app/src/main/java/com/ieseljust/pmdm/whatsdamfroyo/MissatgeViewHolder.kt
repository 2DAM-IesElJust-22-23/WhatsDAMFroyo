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

class MissatgeViewHolder(itemView: View) :

    View.OnClickListener,
    RecyclerView.ViewHolder(itemView){
        val text: TextView = itemView.findViewById(R.id.msg_text) as TextView
        val temps: TextView = itemView.findViewById(R.id.msg_me_timestamp) as TextView




        init {
            itemView.setOnClickListener(this)
        }


    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(
        missatge: Missatge,
        ){
        text.text=missatge.text



        val dateFormat=SimpleDateFormat("HH:mm")
        val horaActual= Date()
        val horaFormatada=dateFormat.format(horaActual)
        temps.text= horaFormatada
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }


}
