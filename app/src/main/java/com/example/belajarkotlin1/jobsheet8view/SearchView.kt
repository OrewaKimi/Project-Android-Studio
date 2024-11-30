package com.example.belajarkotlin1.jobsheet8view

import android.os.Bundle
import android.widget.SearchView as AndroidSearchView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.belajarkotlin1.R

class SearchView : AppCompatActivity() {

    private val userList = listOf(
        User("Kimi Maulana", "kimimaulana@gmail.com"),
        User("Monkey D Luffy", "monkydluffy.com"),
        User("Roronoa Zoro", "roronoazoro@gmail.com"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_view)
        val searchView = findViewById<AndroidSearchView>(R.id.searchView)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        searchView.setOnQueryTextListener(object : AndroidSearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterUsers(newText.orEmpty(), resultTextView)
                return true
            }
        })
    }

    private fun filterUsers(query: String, resultTextView: TextView) {
        val filteredUsers = userList.filter { it.name.contains(query, ignoreCase = true) }
        if (filteredUsers.isNotEmpty()) {
            val result = filteredUsers.joinToString(separator = "\n") { it.name }
            resultTextView.text = result
        } else {
            resultTextView.text = "No results found"
        }
    }
}