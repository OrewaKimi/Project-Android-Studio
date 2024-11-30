@file:Suppress("DEPRECATION")

package com.example.belajarkotlin1.jobsheet8view

import android.os.Bundle
import android.widget.TabHost
import androidx.appcompat.app.AppCompatActivity
import com.example.belajarkotlin1.R

class TabHostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_host)

        val tabHost = findViewById<TabHost>(R.id.tabHost)
        tabHost.setup()

        val tabSpec1 = tabHost.newTabSpec("Tab Satu")
        tabSpec1.setContent(R.id.tab1)
        tabSpec1.setIndicator("Cari Pengguna")
        tabHost.addTab(tabSpec1)

        val tabSpec2 = tabHost.newTabSpec("Tab Dua")
        tabSpec2.setContent(R.id.tab2)
        tabSpec2.setIndicator("Tab 2")
        tabHost.addTab(tabSpec2)
    }
}
