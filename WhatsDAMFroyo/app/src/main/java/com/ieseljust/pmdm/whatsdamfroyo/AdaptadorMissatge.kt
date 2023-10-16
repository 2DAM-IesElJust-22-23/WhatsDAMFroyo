package com.ieseljust.pmdm.whatsdamfroyo

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

class AdaptadorMissatge(
    val context: Context,
    val eventListener: (Missatge, View) -> Boolean)
    :RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val vista=inflater.inflate(
            R.layout.my_msg_viewholder,
            parent,false);
        return MissatgeViewHolder(vista,context)

    }

    override fun getItemCount(): Int {
        return Missatges.missatges.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

            (holder as MissatgeViewHolder).bind(
                Missatges.missatges[position],
                eventListener)
    }
}