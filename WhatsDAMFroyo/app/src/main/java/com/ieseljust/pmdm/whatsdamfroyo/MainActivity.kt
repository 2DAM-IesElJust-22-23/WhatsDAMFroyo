package com.ieseljust.pmdm.whatsdamfroyo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Nickname
import com.ieseljust.pmdm.whatsdamfroyo.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        binding.buttonConnect.setOnClickListener {

            val intent = Intent(this, MessagesWindow::class.java)
            startActivity(intent)


        }

    }
}
