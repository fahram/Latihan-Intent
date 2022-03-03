package com.fahram.latihanintent

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MoveWithObjectActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MAHASISWA = "extra_mahasiswa"
    }

    lateinit var tvMoveWithObject: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)
        val (nim, nama) = intent.getParcelableExtra<Mahasiswa>(EXTRA_MAHASISWA) as Mahasiswa
        tvMoveWithObject = findViewById(R.id.tv_move_with_object)
        tvMoveWithObject.text = "Nama : $nama , Nim : $nim"

    }
}