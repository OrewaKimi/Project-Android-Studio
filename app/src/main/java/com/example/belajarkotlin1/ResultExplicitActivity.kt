package com.example.belajarkotlin1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultExplicitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_explicit)

        val message = intent.getStringExtra("EXTRA_MESSAGE")
        val textResult = findViewById<TextView>(R.id.textresultexplicit)
        textResult.text = message
    }
}
