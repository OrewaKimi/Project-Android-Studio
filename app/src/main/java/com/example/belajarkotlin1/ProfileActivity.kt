package com.example.belajarkotlin1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val name = intent.getStringExtra("EXTRA_NAME")
        val age = intent.getStringExtra("EXTRA_AGE")

        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        textViewResult.text = "Nama: $name\nUmur: $age"
    }
}
