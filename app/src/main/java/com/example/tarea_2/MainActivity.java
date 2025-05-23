package com.example.tarea_2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    RecyclerView recyclerViewLibros;
    AdapterPersonalizado adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.inicio_navigation_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayShowTitleEnabled(false);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView mNavigationView = findViewById(R.id.left_drawer);

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.DrawerOpen, R.string.DrawerClosed) {
            public void onDrawerClosed(View view){
                Log.d("MainActivity", "onDrawerClosed");
            }
            public void onDrawerOpened(View drawerView){
                Log.d("MainActivity", "onDrawerOpened");
            }
        };

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.profile) {
                    Log.d("MainActivity", "ver perfil");
                  //  Toast.makeText(MainActivity.this, "ver perfil", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.action_favs) {
                    Log.d("MainActivity", "ver libros favoritos");
                  //  Toast.makeText(MainActivity.this, "libros favoritos", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.action_cart) {
                    Log.d("MainActivity", "ver carrito");
                  //  Toast.makeText(MainActivity.this, "ver carrito", Toast.LENGTH_SHORT).show();
                }  else if (id == R.id.gen_misterio) {
                    Log.d("MainActivity", "libros de misterio");
                   // Toast.makeText(MainActivity.this, "libros de misterio", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.gen_historia) {
                    Log.d("MainActivity", "libros de historia");
                   // Toast.makeText(MainActivity.this, "libros de historia", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.gen_poesia) {
                    Log.d("MainActivity", "libros de poesía");
                 //   Toast.makeText(MainActivity.this, "libros de poesía", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.gen_terror) {
                    Log.d("MainActivity", "libros de terror");
                  //  Toast.makeText(MainActivity.this, "libros de terror", Toast.LENGTH_SHORT).show();
                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerViewLibros = findViewById(R.id.list_all_gnros);
        recyclerViewLibros.setLayoutManager(new LinearLayoutManager(this));
        adaptador = new AdapterPersonalizado(libros(), this);
        recyclerViewLibros.setAdapter(adaptador);
    }

    private ArrayList<Book> libros() {
        ArrayList<Book> lista = new ArrayList<>();
        lista.add(new Book(R.drawable.misterio_1, "Y no quedó ninguno", "Agatha Christie"));
        lista.add(new Book(R.drawable.misterio_2, "Un cadáver en la biblioteca", "Agatha Christie"));
        lista.add(new Book(R.drawable.misterio_3, "Extraordinario", "Stephen Chbosky"));
        lista.add(new Book(R.drawable.misterio_4, "La chica del tren", "Paula Hawkins"));
        lista.add(new Book(R.drawable.poesia_1, "Violet bent backwards over the grass", "Lana Del Rey"));
        lista.add(new Book(R.drawable.poesia_2, "Azul", "Rubén Darío"));
        lista.add(new Book(R.drawable.poesia_3, "Donde viven las musas", "Marianela Dos Santos"));
        lista.add(new Book(R.drawable.poesia_4, "Poesía completa", "Alejandra Pizarnik"));
        lista.add(new Book(R.drawable.terror_1, "Cadáver exquisito", "Agustina Bazterrica"));
        lista.add(new Book(R.drawable.terror_2, "Cómo vender una casa embrujada", "Grady Hendrix"));
        lista.add(new Book(R.drawable.terror_3, "La casa infernal", "Richard Matheson"));
        lista.add(new Book(R.drawable.historia_1, "Circe", "Madeline Miller"));

        return lista;
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
            Log.d("MainActivity", "buscar libro");
           // Toast.makeText(MainActivity.this, "buscar libro", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_notifs) {
            Log.d("MainActivity", "ver notificaciones");
          //  Toast.makeText(MainActivity.this, "ver notificaciones", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_config) {
            Log.d("MainActivity", "configuración");
           // Toast.makeText(MainActivity.this, "configuración", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_logout) {
            Log.d("MainActivity", "cerrar sesión");
          //  Toast.makeText(MainActivity.this, "cerrar sesión", Toast.LENGTH_SHORT).show();
            getSharedPreferences("sesion", MODE_PRIVATE)
                    .edit()
                    .putBoolean("logged", false)
                    .apply();

            Intent intent = new Intent(MainActivity.this, IniciarSesionActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}