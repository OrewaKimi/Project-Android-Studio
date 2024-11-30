package com.example.belajarkotlin1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ExplicitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_explicit)
        val buttonSendMessage = findViewById<Button>(R.id.send_message_via_intent)
        buttonSendMessage.setOnClickListener {
            val intent = Intent(this, ResultExplicitActivity::class.java)
            intent.putExtra("EXTRA_MESSAGE", "Ini adalah message dari Explicit Activity")
            startActivity(intent)
        }
    }
}
