package com.ieseljust.pmdm.whatsdamfroyo

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class AdaptadorMissatge(
  private val llistaMissatges : List<Missatge>,
    )
    :RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.my_msg_viewholder,parent, false)


        return MissatgeViewHolder(vista)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return llistaMissatges.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
     fun onBindViewHolder(holder: MissatgeViewHolder, position: Int) {

            val missatge= llistaMissatges[position]
            holder.bind(missatge)
    }
}