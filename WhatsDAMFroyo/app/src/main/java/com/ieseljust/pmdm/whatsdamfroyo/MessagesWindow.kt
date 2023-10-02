package com.ieseljust.pmdm.whatsdamfroyo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ieseljust.pmdm.whatsdamfroyo.databinding.ActivityMessagesWindowBinding

class MessagesWindow : AppCompatActivity() {
    private lateinit var  binding: ActivityMessagesWindowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMessagesWindowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val textMensaje=binding.MessageText
        val textview= binding.connectionInfoTextView
        val enviarMensaje= binding.sendMessage

        val usuari=intent.getStringExtra("usuari")
        val ipServidor=intent.getStringExtra("ipservidor")

        textview.text="Conectat a $ipServidor com a $usuari"
        enviarMensaje.setOnClickListener{
            textMensaje.text.clear()
        }
    }







}