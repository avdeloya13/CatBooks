package com.example.tarea_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IniciarSesionActivity extends AppCompatActivity{
    private Button connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        boolean logged = getSharedPreferences("sesion", MODE_PRIVATE)
                .getBoolean("logged", false);

        if (logged) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
            return;
        }
        setContentView(R.layout.login);

        connection = findViewById(R.id.accessbtn);
        connection.setOnClickListener(v -> {
            getSharedPreferences("user_session", MODE_PRIVATE).edit().putBoolean("logged_in", true).apply();
            startActivity(new Intent(IniciarSesionActivity.this, MainActivity.class));
            finish();
        });

        connection = findViewById(R.id.regisbtn);
        connection.setOnClickListener(v -> {
            Intent intent = new Intent(IniciarSesionActivity.this, RegistroActivity.class);
            startActivity(intent);
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
