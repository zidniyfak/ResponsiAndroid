package com.example.responsiandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.responsiandroid.R
import com.example.responsiandroid.model.MahasiswaItem
import kotlinx.android.synthetic.main.mahasiswa_item.view.*

class MahasiswaAdapter(private val list: ArrayList<MahasiswaItem>):RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {
    inner class MahasiswaViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(mahasiswaItem: MahasiswaItem){
            with(itemView){
                tv_npm.text = "${mahasiswaItem.npm}"
                tv_nama.text = "${mahasiswaItem.namaMhs}"
                tv_jurusan.text = "${mahasiswaItem.jurusanMhs}"
                tv_kelamin.text = "${mahasiswaItem.jenisKelamin}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mahasiswa_item,parent,false)

        return MahasiswaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}