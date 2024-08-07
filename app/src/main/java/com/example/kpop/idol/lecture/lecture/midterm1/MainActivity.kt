package com.example.kpop.idol.lecture.lecture.midterm1

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
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

        val operationSpinner: Spinner = findViewById(R.id.operation_spinner)
        val number1EditText: EditText = findViewById(R.id.number_1)
        val number2EditText: EditText = findViewById(R.id.number_2)
        val calculateButton: Button = findViewById(R.id.calculate_btn)
        val resultTextView: TextView = findViewById(R.id.result_txt)

        val operationOptions = arrayOf("Add", "Subtract", "Multiply", "Divide")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, operationOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        operationSpinner.adapter = adapter

        var selectedOperation = operationOptions.get(0)

        operationSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selectedOperation = operationOptions.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        calculateButton.setOnClickListener {
            val number1 = number1EditText.text.toString().toDouble()
            val number2 = number2EditText.text.toString().toDouble()

            val result = when (selectedOperation) {
                "Add" -> number1 + number2
                "Subtract" -> number1 - number2
                "Multiply" -> number1 * number2
                "Divide" -> number1 / number2
                else -> 0.0
            }
            resultTextView.text = result.toString()
        }
    }
}