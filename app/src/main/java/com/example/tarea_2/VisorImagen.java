package com.example.tarea_2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class VisorImagen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_imagen);

        Book libro = (Book) getIntent().getSerializableExtra("book");

        //Referencia al ImageView
        ImageView imagen = findViewById(R.id.visorBook);

        //Muestra la imagen
        if (libro != null) {
            imagen.setImageResource(libro.getIdImagen());
        }
    }
}
