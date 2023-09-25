package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Click handler for the addition button
    public void addFunction(View view) {
        performOperation(Operation.ADD);
    }

    // Click handler for the subtraction button
    public void subtractFunction(View view) {
        performOperation(Operation.SUBTRACT);
    }

    // Click handler for the multiplication button
    public void multiplyFunction(View view) {
        performOperation(Operation.MULTIPLY);
    }

    // Click handler for the division button
    public void divideFunction(View view) {
        performOperation(Operation.DIVIDE);
    }

    // Method to perform operations based on the selected operation
    private void performOperation(Operation operation) {
        EditText editTextNumber1 = findViewById(R.id.editTextNumber1);
        EditText editTextNumber2 = findViewById(R.id.editTextNumber2);

        double num1, num2;

        try {
            num1 = Double.parseDouble(editTextNumber1.getText().toString());
            num2 = Double.parseDouble(editTextNumber2.getText().toString());

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
            return; // Return if input is invalid
        }

        double result;

        switch (operation) {
            case ADD:
                result = num1 + num2;
                break;
            case SUBTRACT:
                result = num1 - num2;
                break;
            case MULTIPLY:
                result = num1 * num2;
                break;
            case DIVIDE:
                if (num2 == 0) {
                    Toast.makeText(this, "The number cannot be divided by 0", Toast.LENGTH_SHORT).show();
                    return; // Return if division by zero is attempted
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + operation);
        }

        // Start the ResultActivity with the result as an extra
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }
}
