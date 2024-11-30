package com.example.belajarkotlin1.utscombine

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.belajarkotlin1.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.URL
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

//Inisialisasi Aplikasi
class WeatherApp : AppCompatActivity() {

    //menjaga variabel tersebut agar tidak diakses atau diubah oleh kelas lain, membuat kode lebih terstruktur, aman, dan lebih mudah untuk dipelihara.
    private val CITY: String = "Jakarta"
    private val API: String = "02bd420c1e94fac13db0fb0088951b9a"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_app)

        fetchWeatherData()
    }

    //Mengambil Data Cuaca
    private fun fetchWeatherData() {
        // Menampilkan loader saat data sedang diambil
        findViewById<ProgressBar>(R.id.loader).visibility = View.VISIBLE
        findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.GONE
        findViewById<TextView>(R.id.errorText).visibility = View.GONE

        //Mengambil Data Secara Asinkron
        CoroutineScope(Dispatchers.IO).launch {
            val result = fetchWeather()
            withContext(Dispatchers.Main) {
                handleResponse(result)
            }
        }
    }

    // fungsi suspend,berarti dapat dijeda dan dilanjutkan kembali tanpa memblokir thread utama
    //deklarasi standar untuk sebuah fungsi di Kotlin
    private suspend fun fetchWeather(): String? {
        return try {
            // Memanggil API OpenWeatherMap untuk mendapatkan data cuaca
            URL("https://api.openweathermap.org/data/2.5/weather?q=$CITY&units=metric&appid=$API").readText(Charsets.UTF_8)
        } catch (e: Exception) {
            null
        }
    }

    private fun handleResponse(result: String?) {
        if (result != null) {
            try {
                // Memparsing JSON yang diterima dari API
                val jsonObj = JSONObject(result)
                val main = jsonObj.getJSONObject("main") //Mengambil objek JSON yang berisi data utama seperti suhu dan kelembapan.
                val sys = jsonObj.getJSONObject("sys") //Mengambil objek JSON yang berisi informasi sistem seperti negara dan waktu matahari terbit/terbenam.
                val wind = jsonObj.getJSONObject("wind")//Mengambil objek JSON yang berisi data tentang kecepatan dan arah angin.
                val weather = jsonObj.getJSONArray("weather").getJSONObject(0)//Mengambil elemen pertama dari array "weather", yang berisi deskripsi cuaca.

                val updatedAt: Long = jsonObj.getLong("dt")//untuk memberi tahu pengguna kapan informasi cuaca yang mereka lihat diambil dari server, sehingga mereka dapat mengetahui seberapa baru data tersebut.
                val updatedAtText = "Updated at: " + SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(Date(updatedAt * 1000))
                val temp = main.getString("temp") + "°C"
                val tempMin = "Min Temp: " + main.getString("temp_min") + "°C"
                val tempMax = "Max Temp: " + main.getString("temp_max") + "°C"
                val pressure = main.getString("pressure")
                val humidity = main.getString("humidity")

                val sunrise: Long = sys.getLong("sunrise")
                val sunset: Long = sys.getLong("sunset")
                val windSpeed = wind.getString("speed")
                val weatherDescription = weather.getString("description").replaceFirstChar { it.uppercase() }

                val address = "${jsonObj.getString("name")}, ${sys.getString("country")}"

                // Mengupdate UI dengan data cuaca yang diterima
                findViewById<TextView>(R.id.address).text = address
                findViewById<TextView>(R.id.updated_at).text = updatedAtText
                findViewById<TextView>(R.id.status).text = weatherDescription
                findViewById<TextView>(R.id.temp).text = temp
                findViewById<TextView>(R.id.temp_min).text = tempMin
                findViewById<TextView>(R.id.temp_max).text = tempMax
                findViewById<TextView>(R.id.sunrise).text = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunrise * 1000))
                findViewById<TextView>(R.id.sunset).text = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunset * 1000))
                findViewById<TextView>(R.id.wind).text = windSpeed
                findViewById<TextView>(R.id.pressure).text = pressure
                findViewById<TextView>(R.id.humidity).text = humidity

                // Sembunyikan loader dan tampilkan hasilnya
                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.VISIBLE
            } catch (e: Exception) {
                // Jika ada kesalahan dalam parsing JSON
                showError()
            }
        } else {
            // Jika data dari API gagal diambil
            showError()
        }
    }

    private fun showError() {
        // Menampilkan pesan error jika terjadi kesalahan
        findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
        findViewById<TextView>(R.id.errorText).visibility = View.VISIBLE
    }
}
//Singkatnya, alur aplikasi adalah:
//1. Saat aplikasi dibuka, aplikasi menampilkan loader.
//2. Aplikasi mengambil data cuaca dari OpenWeatherMap API untuk kota Jakarta.
//3. Data JSON diproses untuk menampilkan suhu, deskripsi cuaca, waktu terbit/tenggelamnya matahari, dll.
//UI diperbarui dengan informasi cuaca atau pesan error jika terjadi masalah.
//Aplikasi ini mengimplementasikan pengambilan data secara real-time dengan API dan
//menampilkan data di aplikasi Android dengan UI yang responsif.