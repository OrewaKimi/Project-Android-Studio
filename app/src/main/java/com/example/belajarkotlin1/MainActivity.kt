package com.example.belajarkotlin1

import android.os.Bundle
import android.widget.Button
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.belajarkotlin1.jobsheet4layout.LayoutActivity
import com.example.belajarkotlin1.jobsheet5dialog.DialogActivity
import com.example.belajarkotlin1.utscombine.WeatherApp
import com.example.belajarkotlin1.jobsheet7adapter.RecycleActivity
import com.example.belajarkotlin1.jobsheet8view.MenuView
import com.example.belajarkotlin1.jobsheet9Notification.NotificationActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonGoToSecondActivity = findViewById<Button>(R.id.buttonGoToSecondActivity)
        val buttonGoToIntentActivity = findViewById<Button>(R.id.buttonGoToIntentActivity)
        val buttonGoToPertemuan4 = findViewById<Button>(R.id.buttonGoToPertemuan4)
        val buttonGoToPertemuan5Fragment = findViewById<Button>(R.id.buttonGoToPertemuan5Fragment)
        val buttonGoToPertemuan6Layout = findViewById<Button>(R.id.buttonGoToPertemuan6Layout)
        val buttonGoToPertemuan7Dialog = findViewById<Button>(R.id.buttonGoToPertemuan7Dialog)
        val buttonGoToWeatherApp = findViewById<Button>(R.id.buttonGoToWeatherApp)
        val button_to_adapter = findViewById<Button>(R.id.button_to_adapter)
        val button_to_view = findViewById<Button>(R.id.button_to_view)
        val buttonNotification = findViewById<Button>(R.id.buttonNotification)

        // Navigate to SecondActivity
        buttonGoToSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        // Navigate to IntentActivity (Pertemuan 3)
        buttonGoToIntentActivity.setOnClickListener {
            val intent = Intent(this, IntentActivity::class.java)
            startActivity(intent)
        }

        // Navigate to Pertemuan4Activity (input name and age)
        buttonGoToPertemuan4.setOnClickListener {
            val intent = Intent(this, Pertemuan4Activity::class.java)
            startActivity(intent)
        }

        // Navigate to FragmentActivity (Pertemuan 5 - Fragment)
        buttonGoToPertemuan5Fragment.setOnClickListener {
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }

        // Navigate to LayoutActivity (Pertemuan 6 - Layout Examples)
        buttonGoToPertemuan6Layout.setOnClickListener {
            val intent = Intent(this, LayoutActivity::class.java)
            startActivity(intent)
        }
        buttonGoToPertemuan7Dialog.setOnClickListener {
            val intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }
        // Navigate to Recipe Finder
        buttonGoToWeatherApp.setOnClickListener {
            val intent = Intent(this, WeatherApp::class.java)
            startActivity(intent)
        }
        //Navigate To Adapter
        button_to_adapter.setOnClickListener {
            val intent = Intent(this, RecycleActivity::class.java)
            startActivity(intent)
        }
        //Navigate To View
        button_to_view.setOnClickListener {
            val intent = Intent(this, MenuView::class.java)
            startActivity(intent)
        }
        //Navigate To Notification
        buttonNotification.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }
    }
}