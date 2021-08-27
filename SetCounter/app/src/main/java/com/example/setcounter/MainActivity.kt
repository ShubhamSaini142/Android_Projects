package com.example.setcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var countBtn : Button
    private lateinit var showCount : TextView
    private lateinit var resetCountBtn : Button
    private lateinit var startBtn : Button
    private lateinit var pauseBtn : Button
    private lateinit var resetBtn : Button
    private lateinit var resetBoth : Button
    private var count : Int = 1
    private var running : Boolean = false
    private var pauseOffset : Long = 0
    private lateinit var chronometer: Chronometer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializer()
        btnListener()
    }
    private fun initializer(){
        countBtn = findViewById(R.id.button)
        showCount =  findViewById(R.id.textView)
        resetCountBtn = findViewById(R.id.button2)
        startBtn = findViewById(R.id.startBtn)
        pauseBtn = findViewById(R.id.pauseBtn)
        resetBtn = findViewById(R.id.resetBtn)
        chronometer = findViewById(R.id.chronometer)
        resetBoth = findViewById(R.id.resetBoth)
    }

    private fun btnListener(){
        resetCountBtn.setOnClickListener {
            count = 1
            showCount.setText("Sets")
        }
        countBtn.setOnClickListener {
            var c1 : Int =   count++
            showCount.setText(c1.toString())
            //Stopwatch
            if (!running){
                chronometer.base = SystemClock.elapsedRealtime()-pauseOffset
                chronometer.start()
                running = true
            }
        }
        startBtn.setOnClickListener{
            if (!running){
                chronometer.base = SystemClock.elapsedRealtime()-pauseOffset
                chronometer.start()
                running = true
            }
        }
        pauseBtn.setOnClickListener {
            if (running) {
                chronometer.stop()
                pauseOffset = SystemClock.elapsedRealtime() - chronometer.base
                running = false
            }
        }
        resetBtn.setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime()
            pauseOffset = 0
        }
        resetBoth.setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime()
            pauseOffset = 0
            chronometer.stop()
            //for count
            count = 1
            showCount.setText("Count")

        }


    }
}