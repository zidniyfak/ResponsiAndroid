package com.example.responsiandroid

import android.net.DnsResolver
import android.net.DnsResolver.Callback
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.responsiandroid.adapter.MahasiswaAdapter
import com.example.responsiandroid.api.RetrofitClient
import com.example.responsiandroid.databinding.ActivityMainBinding
import com.example.responsiandroid.model.MahasiswaItem
import com.example.responsiandroid.model.MahasiswaResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var list = ArrayList<MahasiswaItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showMahasiswa()
    }

    private fun showMahasiswa() {
        RetrofitClient.instance.getMhs().enqueue(object : retrofit2.Callback<MahasiswaResponse>{
            override fun onResponse(
                call: Call<MahasiswaResponse>,
                response: Response<MahasiswaResponse>
            ) {
                binding.rvMhs.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(this@MainActivity)
                }

                val listResponse = response.body()?.mahasiswa
                listResponse?.let { list.addAll(it) }
                val adapter = MahasiswaAdapter(list)
                rv_mhs.adapter = adapter
            }

            override fun onFailure(call: Call<MahasiswaResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.message.toString(),Toast.LENGTH_LONG).show()
            }
        })
    }
}