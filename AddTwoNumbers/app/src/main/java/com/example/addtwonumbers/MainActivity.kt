package com.example.addtwonumbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.NumberFormatException
import kotlin.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var n1: EditText
    private lateinit var n2: EditText
    private lateinit var results: TextView
    private lateinit var btn: Button
    private var max : Int = Int.MAX_VALUE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        n1 = findViewById(R.id.editTextNumber)
        n2 = findViewById(R.id.editTextNumber2)
        results = findViewById(R.id.textView2)
        btn = findViewById(R.id.button)




        btn.setOnClickListener {
            try {
                var num1: Int = n1.text.toString().toInt()
                var num2: Int = n2.text.toString().toInt()
                var sum: Int = num1 + num2
              results.setText(sum.toString())
            }
            catch (e: Exception){
                results.setText("PLEASE ENTER BOTH DIGITS")
            }

        }
    }
}