package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText n1;
    EditText n2;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1 = (EditText) findViewById(R.id.Number_1);
        n2 = (EditText) findViewById(R.id.Number_2);
        result = (TextView) findViewById(R.id.Result_id);
        addFunction();
        subFunction();
        MultiplicationFunction();

        DivideFunction();
    }

    private void addFunction(){
        Button btn = findViewById(R.id.Addition);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(n1.getText().toString());
                int num2 = Integer.parseInt(n2.getText().toString());
                int sum = num1 + num2;
                result.setText(Integer.toString(sum));
            }
        });

    }


    private void subFunction(){
        Button btn = findViewById(R.id.Subtraction);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(n1.getText().toString());
                int num2 = Integer.parseInt(n2.getText().toString());
                int sum = num1 - num2;
                result.setText(Integer.toString(sum));
            }
        });

    }


    private void MultiplicationFunction(){
        Button btn = findViewById(R.id.multiplication);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(n1.getText().toString());
                int num2 = Integer.parseInt(n2.getText().toString());
                int sum = num1 * num2;
                result.setText(Integer.toString(sum));
            }
        });

    }


    private void DivideFunction(){
        Button btn = findViewById(R.id.Divide);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double num1 = Double.parseDouble(n1.getText().toString());
                Double num2 = Double.parseDouble(n2.getText().toString());
                Double sum = num1 / num2;
                result.setText(Double.toString(sum));
            }
        });

    }


}