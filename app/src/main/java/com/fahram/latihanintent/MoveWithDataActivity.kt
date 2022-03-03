package com.fahram.latihanintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithDataActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_NAMA = "extra_nama"
        const val EXTRA_NIM = "extra_nim"
    }
    lateinit var tvData : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)
        tvData = findViewById(R.id.tv_move_with_data)
        val nama = intent.getStringExtra(EXTRA_NAMA)
        val nim = intent.getIntExtra(EXTRA_NIM, 0)
        tvData.text = "Nama : $nama , Nim : $nim"
    }
}