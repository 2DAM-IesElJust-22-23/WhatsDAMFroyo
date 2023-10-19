package com.ieseljust.pmdm.whatsdamfroyo

import android.content.Intent
import android.net.InetAddresses.isNumericAddress
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Nickname
import androidx.annotation.RequiresApi
import com.ieseljust.pmdm.whatsdamfroyo.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var usuari=""
    private var ipservidor=""

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(savedInstanceState!=null){
            usuari=savedInstanceState.getString("usuari","")
            ipservidor=savedInstanceState.getString("ipservidor","")
        }

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
