package com.example.responsiandroid.api

import com.example.responsiandroid.model.MahasiswaResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("mahasiswa")
    fun getMhs():Call<MahasiswaResponse>
}