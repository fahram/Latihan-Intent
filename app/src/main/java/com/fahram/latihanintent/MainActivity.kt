package com.fahram.latihanintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnMove : Button
    lateinit var btnMoveWithData: Button
    lateinit var btnMoveWithObject: Button
    lateinit var btnDial: Button
    lateinit var btnMoveWithResult: Button
    lateinit var tvResult: TextView

    private val registerLaucher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null)
        {
            val data = result.data?.getStringExtra(MoveForResultActivity.EXTRA_RESULT)
            tvResult.text = "Hai $data"
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnMove = findViewById(R.id.btn_move)
        btnMoveWithData = findViewById(R.id.btn_move_with_data)
        btnMoveWithObject = findViewById(R.id.btn_move_with_object)
        btnDial = findViewById(R.id.btn_dial)
        btnMoveWithResult = findViewById(R.id.btn_move_for_result)
        tvResult = findViewById(R.id.tv_result)

        btnMove.setOnClickListener(this)
        btnMoveWithData.setOnClickListener(this)
        btnMoveWithObject.setOnClickListener(this)
        btnDial.setOnClickListener(this)
        btnMoveWithResult.setOnClickListener(this)

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
            R.id.btn_dial -> {
                startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:0816689298")))
            }

            R.id.btn_move_for_result -> {
                val intent = Intent(this@MainActivity, MoveForResultActivity::class.java);
                registerLaucher.launch(intent)
            }
        }
    }

}