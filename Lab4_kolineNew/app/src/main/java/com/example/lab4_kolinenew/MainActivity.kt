package com.example.lab4_kolinenew

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var btn_select = findViewById<Button>(R.id.btnChoice)
        btn_select.setOnClickListener {
            mStarforResult.launch(Intent(this,SecActivity::class.java))
        }

    }

    private val mStarforResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data

            val drink = intent?.getStringExtra("drink")
            val sugar = intent?.getStringExtra("sugar")
            val ice = intent?.getStringExtra("ice")
            val tv_meal = findViewById<TextView>(R.id.tvMeal)
            tv_meal.text = "飲料: ${drink}\n\n甜度: ${sugar}\n\n冰塊: ${ice}\n\n"

        }
    }






}


