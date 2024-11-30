package com.example.belajarkotlin1.jobsheet8view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.belajarkotlin1.R

class MenuView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_view)

        val buttonSearchView = findViewById<Button>(R.id.button_to_searchview)
        buttonSearchView.setOnClickListener {
            val intent = Intent(this, SearchView::class.java)
            startActivity(intent)
        }

        val buttonTabHost = findViewById<Button>(R.id.button_to_tabhost)
        buttonTabHost.setOnClickListener {
            val intent = Intent(this, TabHostActivity::class.java)
            startActivity(intent)
        }
    }
}
