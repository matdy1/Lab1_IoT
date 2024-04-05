package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private TextView textViewTeleMath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewTeleMath = findViewById(R.id.textViewTeleMath);

        // Registrar el menú contextual para el TextView
        registerForContextMenu(textViewTeleMath);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.color_blue) {
            textViewTeleMath.setTextColor(Color.BLUE);
            return true;
        } else if (id == R.id.color_green) {
            textViewTeleMath.setTextColor(Color.GREEN);
            return true;
        } else if (id == R.id.color_red) {
            textViewTeleMath.setTextColor(Color.RED);
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }

    public void irAVentana2(View view) {
        Intent intent = new Intent(this, MainActivity2_indicaciones.class);
        startActivity(intent);
    }

    public void irAVentana3(View view) {
        Intent intent = new Intent(this, MainActivity2_calculadora.class);
        startActivity(intent);

    }
}