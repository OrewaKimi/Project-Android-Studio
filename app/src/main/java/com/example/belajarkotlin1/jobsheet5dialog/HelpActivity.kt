package com.example.belajarkotlin1.jobsheet5dialog

import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.belajarkotlin1.R

class HelpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_help)

        // Mengubah judul di ActionBar
        supportActionBar?.title = "Halaman Bantuan"

        // Menambahkan callback untuk tombol "Back"
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Tampilkan pesan atau aksi khusus jika diperlukan
                Toast.makeText(this@HelpActivity, "Kembali ke halaman utama", Toast.LENGTH_SHORT).show()
                // Panggil onBackPressed secara manual untuk kembali ke halaman sebelumnya
                finish() // ini menutup HelpActivity dan kembali ke aktivitas sebelumnya
            }
        })
    }
}
