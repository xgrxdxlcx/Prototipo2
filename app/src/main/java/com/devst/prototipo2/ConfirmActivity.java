package com.devst.prototipo2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        findViewById(R.id.btnSi).setOnClickListener(v -> {
            setResult(RESULT_OK);
            finish();
        });

        findViewById(R.id.btnNo).setOnClickListener(v -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}
