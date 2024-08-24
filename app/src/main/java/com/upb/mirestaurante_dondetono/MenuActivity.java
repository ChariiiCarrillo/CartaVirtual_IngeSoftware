package com.upb.mirestaurante_dondetono;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuActivity extends ListActivity {

    String [] categoriaProductos = new String[]{"Entradas", "Platos Fuertes", "Bebidas", "Postres"};
    ListView listaCategorias = null;
    private ListAdapter adaptadorlista = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        listaCategorias = findViewById(android.R.id.list);
        adaptadorlista = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categoriaProductos);

        listaCategorias.setAdapter(adaptadorlista);
    }

    protected void onListItemClick (ListView lv, View v, int position, long id){

        super.onListItemClick(lv,v,position,id);
        if(position == 0){

            Intent i; //intent : forma en la que se comunican las clases
            i= new Intent(this, EntradaActivity.class); //(actividad actual , a donde quiere ir)
            startActivity(i); //lanzar la actividad
        }

        if(position == 1){

            Intent i;
            i= new Intent(this, FuerteActivity.class);
            startActivity(i);
        }
        if(position == 2){

            Intent i;
            i= new Intent(this, BebidaActivity.class);
            startActivity(i);
        }
        if(position == 3){

            Intent i;
            i= new Intent(this, PostreActivity.class);
            startActivity(i);
        }


    }
}