package com.devst.prototipo2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfigActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla);

        ((TextView) findViewById(R.id.txtTitulo)).setText("Ajustes ⚙️");
        ((TextView) findViewById(R.id.txtInfo)).setText("Pantalla de ajustes interna");
        findViewById(R.id.btnVolver).setOnClickListener(v -> finish());
    }
}
