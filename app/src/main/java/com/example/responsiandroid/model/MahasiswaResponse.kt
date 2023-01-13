package com.example.responsiandroid.model

import com.google.gson.annotations.SerializedName

data class MahasiswaResponse(

	@field:SerializedName("mahasiswa")
	val mahasiswa: ArrayList<MahasiswaItem>
)

data class MahasiswaItem(

	@field:SerializedName("nama_mhs")
	val namaMhs: String,

	@field:SerializedName("jurusan_mhs")
	val jurusanMhs: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("npm")
	val npm: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("jenis_kelamin")
	val jenisKelamin: String
)
