package com.example.belajarkotlin1.jobsheet7adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.belajarkotlin1.R

class RecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle)

        // List of users
        val fruitList = listOf(
            User("Luffy", R.drawable.luffy),
            User("Zoro", R.drawable.zoro),
            User("Jinbe", R.drawable.jinbe),
            User("Sanji", R.drawable.sanji)
        )

        // Setup RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.rvUser)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FruitAdapter(fruitList)
    }
}