package com.example.lab9_1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val total = intent.getIntExtra("TOTAL", 0)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        resultTextView.text = "Оплатить = $total рублей."
    }
}