package com.example.lab4_kolinenew

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sec)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var edDrink = findViewById<EditText>(R.id.edDrink)
        var rgSugar = findViewById<RadioGroup>(R.id.rgSugar)
        var rgIce = findViewById<RadioGroup>(R.id.rgIce)
        var btnSend = findViewById<Button>(R.id.btnSend)

        btnSend.setOnClickListener {
            // 取得飲料名稱
            val drinkName = edDrink.text.toString()
            // 取得甜度選項
            val sugar = rgSugar.findViewById<RadioButton>(rgSugar.checkedRadioButtonId).text.toString()
            // 取得冰塊選項
            val ice = rgIce.findViewById<RadioButton>(rgIce.checkedRadioButtonId).text.toString()


            val resultIntent = Intent().apply {
                putExtra("drink", drinkName)
                putExtra("sugar", sugar)
                putExtra("ice", ice)
            }

            setResult(Activity.RESULT_OK, resultIntent)
            finish()

        }






    }
}