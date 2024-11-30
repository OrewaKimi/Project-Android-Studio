package com.example.belajarkotlin1.jobsheet4layout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.belajarkotlin1.R

class LayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)

        val buttonLinearlayout = findViewById<Button>(R.id.button_linearlayout)
        val buttonRelativelayout = findViewById<Button>(R.id.button_relativelayout)
        val buttonConstraintlayout = findViewById<Button>(R.id.button_constraintlayout)

        buttonLinearlayout.setOnClickListener {
            startActivity(Intent(this, LinearlayoutActivity::class.java))
        }

        buttonRelativelayout.setOnClickListener {
            startActivity(Intent(this, Relativelayout::class.java))
        }

        buttonConstraintlayout.setOnClickListener {
            startActivity(Intent(this, Constraintlayout::class.java))
        }
    }
}
