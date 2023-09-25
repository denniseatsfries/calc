package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        double result = intent.getDoubleExtra("result", 0);

        TextView textViewResult = findViewById(R.id.textViewResult); // Corrected variable name
        textViewResult.setText(Double.toString(result));
    }
}
