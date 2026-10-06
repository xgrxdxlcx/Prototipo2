package com.devst.prototipo2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla);

        String nombre = getIntent().getStringExtra("nombre");

        ((TextView) findViewById(R.id.txtTitulo)).setText("Detalle");
        ((TextView) findViewById(R.id.txtInfo)).setText("Item recibido: " + nombre);
        findViewById(R.id.btnVolver).setOnClickListener(v -> finish());
    }
}
