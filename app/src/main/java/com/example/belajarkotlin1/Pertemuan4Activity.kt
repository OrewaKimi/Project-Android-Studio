package com.example.belajarkotlin1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Pertemuan4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pertemuan4)

        // Kita definisikan komponen input dan tombol
        val nameEditText = findViewById<EditText>(R.id.editTextName)
        val ageEditText = findViewById<EditText>(R.id.editTextAge)
        val buttonSend = findViewById<Button>(R.id.buttonSend)

        // Lalu kirim data nama dan umur ke ProfileActivity
        buttonSend.setOnClickListener {
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString()

            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("EXTRA_NAME", name)
            intent.putExtra("EXTRA_AGE", age)
            startActivity(intent)
        }
    }
}
