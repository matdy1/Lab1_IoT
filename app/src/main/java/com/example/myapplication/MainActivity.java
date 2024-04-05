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


    private TextView textView;
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

        textView = findViewById(R.id.textViewTeleMath);

        // Registrar el menú contextual para el TextView
        registerForContextMenu(textView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        // Verifica si el ID del elemento del menú es el que deseas cambiar el color
        if (id == R.id.menu_item_red) {
            textView.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            return true;
        } else if (id == R.id.menu_item_blue) {
            textView.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
            return true;
        } else if (id == R.id.menu_item_green) {
            textView.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
            return true;
        }

        return super.onContextItemSelected(item);
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