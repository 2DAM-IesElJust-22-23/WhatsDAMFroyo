package com.ieseljust.pmdm.whatsdamfroyo.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ieseljust.pmdm.whatsdamfroyo.R
import com.ieseljust.pmdm.whatsdamfroyo.databinding.ActivityMessagesWindowBinding
import com.ieseljust.pmdm.whatsdamfroyo.model.Missatges

class MessagesWindow : AppCompatActivity() {
    private lateinit var  binding: ActivityMessagesWindowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding=ActivityMessagesWindowBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val textMensaje=binding.MessageText
            val textview= binding.connectionInfoTextView
            val enviarMensaje= binding.sendMessage
    //valors de la act anterior
            val usuari=intent.getStringExtra("usuari")
            val ipServidor=intent.getStringExtra("ipservidor")

            textview.text="Conectat a $ipServidor com a $usuari"
            val connectionInfoTextView= findViewById<TextView>(R.id.connectionInfoTextView)
            val textformatado= getString(R.string.connection_info_template, ipServidor,usuari)
            connectionInfoTextView.text= textformatado
    //refs
        val messageTextEdit=findViewById<EditText>(R.id.MessageText)
        val BotoEnviar= findViewById<ImageButton>(R.id.sendMessage)

    //recycler
        val recyclerView=findViewById<RecyclerView>(R.id.MessagesRecyclerView)
        recyclerView.layoutManager= LinearLayoutManager(this)
        val adaptador= AdaptadorMissatge(Missatges.MissatgesObj.llistaMissatges)
        recyclerView.adapter = adaptador


        var viewModel: MissatgesViewModel
        viewModel =
            ViewModelProvider(this)[MissatgesViewModel::class.java]

        viewModel._adaptador.observe(this) {
            binding.MessagesRecyclerView.adapter= it
        }
        binding.sendMessage.setOnClickListener{
            viewModel.add(usuari,textformatado)
        }


        enviarMensaje.setOnClickListener{
                val missatgeTexto=messageTextEdit.text.toString()
                if(missatgeTexto.isNotEmpty()){
                    if (usuari != null) {
                        Missatges.MissatgesObj.afegirMissatge(usuari, missatgeTexto)
                    }
                    adaptador.notifyItemInserted(Missatges.MissatgesObj.llistaMissatges.size -1)
                    recyclerView.scrollToPosition(Missatges.MissatgesObj.llistaMissatges.size -1)
                    textMensaje.text.clear()

                }

            }
    }







}