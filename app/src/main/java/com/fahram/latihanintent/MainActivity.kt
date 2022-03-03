package com.fahram.latihanintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnMove : Button
    lateinit var btnMoveWithData: Button
    lateinit var btnMoveWithObject: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnMove = findViewById(R.id.btn_move)
        btnMoveWithData = findViewById(R.id.btn_move_with_data)
        btnMoveWithObject = findViewById(R.id.btn_move_with_object)

        btnMove.setOnClickListener(this)
        btnMoveWithData.setOnClickListener(this)
        btnMoveWithObject.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move -> {
                startActivity(Intent(this@MainActivity, MoveActivity::class.java))
            }
            R.id.btn_move_with_data -> {
                val intent =  Intent(this@MainActivity, MoveWithDataActivity::class.java)
                intent.putExtra(MoveWithDataActivity.EXTRA_NAMA, "Khaidir Fahram")
                intent.putExtra(MoveWithDataActivity.EXTRA_NIM, 2020202)
                startActivity(intent)
            }
            R.id.btn_move_with_object -> {
                val intent =  Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                val mahasiswa = Mahasiswa(202100210, "Joko Susilo")
                intent.putExtra(MoveWithObjectActivity.EXTRA_MAHASISWA, mahasiswa)
                startActivity(intent)
            }
        }
    }
}