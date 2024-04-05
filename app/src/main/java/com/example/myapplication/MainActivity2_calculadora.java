package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2_calculadora extends AppCompatActivity {
    private TextView textViewOperation;
    private TextView textViewResult;
    private StringBuilder currentNumber;
    private double operand1;
    private char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_calculadora);


        textViewOperation = findViewById(R.id.textViewOperation);
        textViewResult = findViewById(R.id.textViewResult);
        currentNumber = new StringBuilder();

        // Set click listeners for number buttons
        setNumberButtonClickListeners();

        // Set click listeners for operation buttons
        setOperationButtonClickListeners();

        // Set click listener for the equal button
        setEqualButtonClickListener();

        // Set click listener for the clear button
        setClearButtonClickListener();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_calculadora,menu);
        return true;
    }

    private void setNumberButtonClickListeners() {
        int[] numberIds = {R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3,
                R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_7,
                R.id.button_8, R.id.button_9};

        for (int id : numberIds) {
            Button button = findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentNumber.append(((Button) v).getText().toString());
                    textViewResult.setText(currentNumber.toString());
                }
            });
        }
    }

    private void setOperationButtonClickListeners() {
        int[] operationIds = {R.id.button_add, R.id.button_subtract, R.id.button_multiply, R.id.button_divide};

        for (int id : operationIds) {
            Button button = findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    operand1 = Double.parseDouble((currentNumber.toString()));
                    currentNumber.setLength(0);
                    operator = ((Button) v).getText().charAt(0);
                    textViewOperation.setText(String.valueOf(operand1) + " " + operator);
                }
            });
        }
    }

    private double calcularResultado(double operando1, double operando2, char operador) {
        double resultado = 0;
        switch (operador) {
            case '+':
                resultado = operando1 + operando2;
                break;
            case '-':
                resultado = operando1 - operando2;
                break;
            case '*':
                resultado = operando1 * operando2;
                break;
            case '/':
                if (operando2 != 0) {
                    resultado = operando1 / operando2;
                } else {

                }
                break;
        }
        return resultado;
    }

    // Método para manejar el clic en el botón de igualdad
    private void setEqualButtonClickListener() {
        Button button = findViewById(R.id.button_equal);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el segundo operando desde el TextView
                double operando2 = Double.parseDouble(currentNumber.toString());
                // Calcular el resultado utilizando el método calcularResultado
                double resultado = calcularResultado(operand1, operando2, operator);
                // Mostrar el resultado en el TextView

                textViewResult.setText(String.valueOf(resultado));
                textViewOperation.setText("0");
                operand1= resultado;
                currentNumber.setLength(0);

            }
        });
    }

    private void setClearButtonClickListener() {
        Button button = findViewById(R.id.buttonClear);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Limpiar el contenido de textViewResult
                textViewResult.setText("");

                // Limpiar el StringBuilder currentNumber
                currentNumber.setLength(0);
            }
        });
    }

    public void irVentana4(View view) {
        Intent intent = new Intent(this, MainActivity2_historial.class);
        startActivity(intent);
    }
}