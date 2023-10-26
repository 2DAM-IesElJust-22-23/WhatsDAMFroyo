package com.ieseljust.pmdm.whatsdamfroyo.viewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ieseljust.pmdm.whatsdamfroyo.R
import com.ieseljust.pmdm.whatsdamfroyo.model.Missatge
import com.ieseljust.pmdm.whatsdamfroyo.model.Missatges
import com.ieseljust.pmdm.whatsdamfroyo.repository.MissatgeRepository

class AdaptadorMissatge(private val llistaMissatges : List<Missatge>, ) :RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.my_msg_viewholder,parent, false)


        return MissatgeViewHolder(vista)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MissatgeViewHolder).bind(
            MissatgeRepository.getInstance().getMissatges()[position]   )
    }

    override fun getItemCount(): Int {
        return MissatgeRepository.getInstance().getNumMissatges()
    }

     fun onBindViewHolder(holder: MissatgeViewHolder, position: Int) {

            val missatge= llistaMissatges[position]
            holder.bind( MissatgeRepository.getInstance().getMissatges()[position]   )
    }
}