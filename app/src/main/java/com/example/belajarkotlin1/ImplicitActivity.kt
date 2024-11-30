package com.example.belajarkotlin1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ImplicitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_implicit)

        val buttonSendaccessgoogle = findViewById<Button>(R.id.access_google)
        buttonSendaccessgoogle.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.google.com")
            startActivity(intent)
        }

        val buttonSendaccesscontact = findViewById<Button>(R.id.access_contact)
        buttonSendaccesscontact.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("tel:*888#")
            startActivity(intent)
        }
    }
}
