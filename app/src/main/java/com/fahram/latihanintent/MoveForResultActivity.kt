package com.fahram.latihanintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MoveForResultActivity : AppCompatActivity() {
    companion object {
        const val RESULT_CODE = 100
        const val EXTRA_RESULT = "extra_result"
    }

    lateinit var btnForResult: Button
    lateinit var txtName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)
        btnForResult = findViewById(R.id.btn_for_result)
        txtName = findViewById(R.id.editTextTextPersonName)
        btnForResult.setOnClickListener {
            val intent = Intent()
            intent.putExtra(EXTRA_RESULT, txtName.text.toString())
            setResult(RESULT_CODE, intent)
            finish()
        }
    }
}