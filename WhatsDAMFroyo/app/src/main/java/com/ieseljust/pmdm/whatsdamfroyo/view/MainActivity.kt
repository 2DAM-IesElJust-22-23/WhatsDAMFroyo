package com.ieseljust.pmdm.whatsdamfroyo.view

import android.content.Intent
import android.net.InetAddresses.isNumericAddress
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.ieseljust.pmdm.whatsdamfroyo.viewmodel.MessagesWindow
import com.ieseljust.pmdm.whatsdamfroyo.databinding.ActivityMainBinding
import com.ieseljust.pmdm.whatsdamfroyo.viewmodel.MissatgesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var usuari=""
    private var ipservidor=""

    private lateinit var viewModel: MissatgesViewModel

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(savedInstanceState!=null){
            usuari=savedInstanceState.getString("usuari","")
            ipservidor=savedInstanceState.getString("ipservidor","")
        }

// Instanciem el ViewModel mitjançant ViewModelProvider
        viewModel =
            ViewModelProvider(this)[MissatgesViewModel::class.java]

        // Establim un Layout Manager per al RecyclerView



        binding.nickNameText.hint = "usuari"
        binding.serverAddressText.hint= "ipserver"

        binding.buttonConnect.setOnClickListener {

            val intent = Intent(this, MessagesWindow::class.java)
            usuari=binding.nickNameText.text.toString()
            ipservidor=binding.serverAddressText.text.toString()

            if((usuari.isNotEmpty()) and isNumericAddress(ipservidor)){
                intent.putExtra("usuari", usuari)
                intent.putExtra("ipservidor", ipservidor)
                startActivity(intent)
            }





        }




    }

}
