package com.example.belajarkotlin1.jobsheet5dialog

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.example.belajarkotlin1.R

class DialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        // Set ActionBar
        supportActionBar?.title = "Halaman Dialog"

        val toastButton = findViewById<Button>(R.id.btn_toast)
        val snackbarButton = findViewById<Button>(R.id.btn_snackbar)
        val dialogButton = findViewById<Button>(R.id.btn_dialog)

        // Toast Handler
        toastButton.setOnClickListener {
            Toast.makeText(this, "Ini adalah Toast", Toast.LENGTH_SHORT).show()
        }

        // Snackbar Handler
        snackbarButton.setOnClickListener {
            Snackbar.make(it, "Ini adalah Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Tutup") {
                    Toast.makeText(this, "Snackbar Ditutup", Toast.LENGTH_SHORT).show()
                }.show()
        }

        // Dialog Handler
        dialogButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Dialog Contoh")
            builder.setMessage("Apakah Anda ingin melanjutkan?")
            builder.setPositiveButton("Ya") { _, _ ->
                Toast.makeText(this, "Melanjutkan", Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("Tidak") { _, _ ->
                Toast.makeText(this, "Dibatalkan", Toast.LENGTH_SHORT).show()
            }
            builder.show()
        }
    }

    // Inflate the menu; this adds items to the action bar if it is present.
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_dialog_activity, menu)
        return true
    }

    // Handle action bar item clicks here.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                // Display Toast for settings
                Toast.makeText(this, "Pengaturan dipilih", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_help -> {
                // Open HelpActivity
                val intent = Intent(this, HelpActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
