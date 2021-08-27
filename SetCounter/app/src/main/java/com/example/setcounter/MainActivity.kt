package com.example.setcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var btn : Button
    private lateinit var textview : TextView
    private lateinit var btn2 : Button
    private lateinit var startBtn : Button
    private lateinit var pauseBtn : Button
    private lateinit var resetBtn : Button
    private var count : Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializer()
        btnListener()    }
    private fun initializer(){
        btn = findViewById(R.id.button)
        textview =  findViewById(R.id.textView)
        btn2 = findViewById(R.id.button2)
        startBtn = findViewById(R.id.startBtn)
        pauseBtn = findViewById(R.id.pauseBtn)
        resetBtn = findViewById(R.id.resetBtn)
    }

    private fun btnListener(){
        btn2.setOnClickListener {
            count = 1
            textview.setText("Count")
        }
        btn.setOnClickListener {
            var c1 : Int =   count++
            textview.setText(c1.toString())

        }

    }
}