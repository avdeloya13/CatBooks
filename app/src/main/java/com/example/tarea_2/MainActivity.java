package com.example.tarea_2;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        //Tarea_2
        //setContentView(R.layout.login); //Pantalla 1

        //setContentView(R.layout.genero_libro);

        //Tarea_3
        setContentView(R.layout.inicio_navigation_drawer); //Pantalla 2
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.left_drawer);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (id == R.id.profile) {
                    Toast.makeText(MainActivity.this, "Perfil", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.genre) {
                    Toast.makeText(MainActivity.this, "Categorías", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.config) {
                    Toast.makeText(MainActivity.this, "Configuración", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.logout) {
                    Toast.makeText(MainActivity.this, "Cerrar sesión", Toast.LENGTH_SHORT).show();
                }

                // Cierra el drawer después de seleccionar
                drawerLayout.closeDrawers();
                return true;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            Log.d("MainActivity", "action_search");
            Toast.makeText(this, "action_search", Toast.LENGTH_SHORT).show();
            return true;
        }  else if (id == R.id.action_favs) {
            Log.d("MainActivity", "action_favs");
            Toast.makeText(this, "action_favs", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_notifs) {
            Log.d("MainActivity", "action_notifs");
            Toast.makeText(this, "action_notifs", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_cart) {
            Log.d("MainActivity", "action_cart");
            Toast.makeText(this, "action_cart", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

}