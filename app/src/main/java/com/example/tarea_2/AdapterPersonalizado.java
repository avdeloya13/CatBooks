package com.example.tarea_2;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterPersonalizado extends RecyclerView.Adapter<AdapterPersonalizado.ViewHolder>{

    private ArrayList<Book> lista;
    private Context contexto;

    public AdapterPersonalizado(ArrayList<Book> lista, Context contexto) {
        this.lista = lista;
        this.contexto = contexto;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list, parent, false);
        return new ViewHolder(vista, contexto);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View vista;
        private Context contexto;

        public ViewHolder(View itemView, Context contexto) {
            super(itemView);
            this.vista = itemView;
            this.contexto = contexto;
        }

        public void bind(final Book book) {
            ImageView imagen = vista.findViewById(R.id.imageBook);
            TextView titulo = vista.findViewById(R.id.bookTitle);
            TextView autor = vista.findViewById(R.id.bookAutor);

            imagen.setImageResource(book.getIdImagen());
            titulo.setText(book.getTitulo());
            autor.setText(book.getAutor());

            imagen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(contexto, VisorImagen.class);
                    intent.putExtra("book", book);
                    contexto.startActivity(intent);
                }
            });
        }
    }
}
