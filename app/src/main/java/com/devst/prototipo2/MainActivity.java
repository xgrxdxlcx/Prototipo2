package com.devst.prototipo2;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class
MainActivity extends AppCompatActivity {

    EditText etLugar, etUrl, etTelefono, etCorreo, etNombre;
    ActivityResultLauncher<Intent> launcherConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLugar = findViewById(R.id.etLugar);
        etUrl = findViewById(R.id.etUrl);
        etTelefono = findViewById(R.id.etTelefono);
        etCorreo = findViewById(R.id.etCorreo);
        etNombre = findViewById(R.id.etNombre);

        // Respuesta de ConfirmActivity
        launcherConfirm = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        mostrar("Confirmado ✅");
                    } else {
                        mostrar("Cancelado ❌");
                    }
                });

        // ---------- IMPLÍCITOS ----------

        // 1. Google Maps
        findViewById(R.id.btnMapa).setOnClickListener(v -> {
            String lugar = etLugar.getText().toString().trim();
            if (lugar.isEmpty()) {
                etLugar.setError("Ingresa un lugar");
                return;
            }
            abrir(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + Uri.encode(lugar))));
        });

        // 2. Página web
        findViewById(R.id.btnWeb).setOnClickListener(v -> {
            String url = etUrl.getText().toString().trim();
            if (!Patterns.WEB_URL.matcher(url).matches()) {
                etUrl.setError("URL inválida");
                return;
            }
            if (!url.startsWith("http")) {
                url = "https://" + url;
            }
            abrir(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });

        // 3. Marcador telefónico
        findViewById(R.id.btnLlamar).setOnClickListener(v -> {
            String tel = etTelefono.getText().toString().trim();
            if (!Patterns.PHONE.matcher(tel).matches()) {
                etTelefono.setError("Teléfono inválido");
                return;
            }
            abrir(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tel)));
        });

        // 4. Correo
        findViewById(R.id.btnCorreo).setOnClickListener(v -> {
            String correo = etCorreo.getText().toString().trim();
            if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                etCorreo.setError("Correo inválido");
                return;
            }
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + correo));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Hola desde Prototipo 2");
            intent.putExtra(Intent.EXTRA_TEXT, "Mensaje de prueba");
            abrir(intent);
        });

        // 5. Ajustes Wi-Fi
        findViewById(R.id.btnWifi).setOnClickListener(v ->
                abrir(new Intent(Settings.ACTION_WIFI_SETTINGS)));

        // ---------- EXPLÍCITOS ----------

        // 1. Detalle (con extra)
        findViewById(R.id.btnDetalle).setOnClickListener(v -> {
            String nombre = etNombre.getText().toString().trim();
            if (nombre.isEmpty()) {
                etNombre.setError("Ingresa un nombre");
                return;
            }
            Intent intent = new Intent(this, DetalleActivity.class);
            intent.putExtra("nombre", nombre);
            startActivity(intent);
        });

        // 2. Ajustes
        findViewById(R.id.btnConfig).setOnClickListener(v ->
                startActivity(new Intent(this, ConfigActivity.class)));

        // 3. Confirmar (con resultado)
        findViewById(R.id.btnConfirm).setOnClickListener(v ->
                launcherConfirm.launch(new Intent(this, ConfirmActivity.class)));
    }

    // Abre un intent implícito; avisa si no hay app para hacerlo
    private void abrir(Intent intent) {
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            mostrar("No existe una app para esta acción");
        }
    }

    private void mostrar(String texto) {
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
    }
}
