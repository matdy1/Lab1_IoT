package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity2_historial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_historial);

        // Obtener la lista de resultados del intent
        List<Double> listaResultados = (List<Double>) getIntent().getSerializableExtra("LISTA_RESULTADOS");

        // Obtener la referencia al TextView
        TextView textView = findViewById(R.id.textView);

        // Construir el texto con los resultados
        StringBuilder sb = new StringBuilder();
        for (Double resultado : listaResultados) {
            sb.append("Resultado: ").append(resultado).append("\n");
        }
        String texto = sb.toString();

        // Establecer el texto en el TextView
        textView.setText(texto);
    }
}
