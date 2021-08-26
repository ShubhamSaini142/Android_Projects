package com.example.displaymultiplicationtable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.nio.Buffer

class MainActivity : AppCompatActivity() {
    private lateinit var tableBtn : Button
    private lateinit var edtTable : EditText
    private lateinit var tableTextView: TextView
    private lateinit var count : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewInitialize()
        viewTable()

    }

    private fun viewInitialize(){
        tableBtn = findViewById(R.id.tableBtn)
        edtTable = findViewById(R.id.edtText)
        tableTextView = findViewById(R.id.tableTextView)
        count = findViewById(R.id.countEdt)

    }
    private fun viewTable(){

        tableBtn.setOnClickListener {
            try {
                var countNumber = count.text.toString().toInt()
                tableTextView.setText("")
                var tableNumber = edtTable.text.toString().toInt()
                for (i in 1..countNumber) {
                    var product = i * tableNumber
                    tableTextView.append("$tableNumber X $i = $product\n")

                }
            }catch (e: Exception){
                Toast.makeText(this,"Please enter the number",Toast.LENGTH_LONG).show()
            }
        }

    }

}