package com.example.lab9_1

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var sizeSpinner: Spinner
    private lateinit var quantityEditText: EditText
    private lateinit var okButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sizeSpinner = findViewById(R.id.sizeSpinner)
        quantityEditText = findViewById(R.id.quantityEditText)
        okButton = findViewById(R.id.okButton)

        val sizes = listOf("9x12", "10x15", "18x24")
        val prices = mapOf("9x12" to 100, "10x15" to 150, "18x24" to 300)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, sizes)
        sizeSpinner.adapter = adapter

        okButton.setOnClickListener {
            val quantityText = quantityEditText.text.toString()
            val quantity = quantityText.toIntOrNull() ?: 0
            val selectedSize = sizeSpinner.selectedItem.toString()
            val pricePerPhoto = prices[selectedSize] ?: 0

            val total = quantity * pricePerPhoto

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("TOTAL", total)
            startActivity(intent)
        }
    }
}