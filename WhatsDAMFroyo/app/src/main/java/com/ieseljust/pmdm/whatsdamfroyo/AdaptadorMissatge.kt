package com.ieseljust.pmdm.whatsdamfroyo

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class AdaptadorMissatge( private val llistaMissatges : List<Missatge>, ) :RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.my_msg_viewholder,parent, false)


        return MissatgeViewHolder(vista)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MissatgeViewHolder).bind(Missatges.MissatgesObj.llistaMissatges[position]   )
    }

    override fun getItemCount(): Int {
        return llistaMissatges.size
    }

     fun onBindViewHolder(holder: MissatgeViewHolder, position: Int) {

            val missatge= llistaMissatges[position]
            holder.bind(missatge)
    }
}