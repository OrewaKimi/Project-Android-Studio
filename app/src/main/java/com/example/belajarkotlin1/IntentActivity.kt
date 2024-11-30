package com.example.belajarkotlin1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class IntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_intent)
        val buttonExplicit = findViewById<Button>(R.id.button_intent_explicit)
        buttonExplicit.setOnClickListener {
            val intent = Intent(this, ExplicitActivity::class.java)
            startActivity(intent)
        }
        val buttonImplicit = findViewById<Button>(R.id.button_intent_implicit)
        buttonImplicit.setOnClickListener {
            val intent = Intent(this, ImplicitActivity::class.java)
            startActivity(intent)
        }
    }
}