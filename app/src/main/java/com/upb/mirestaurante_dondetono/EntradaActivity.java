package com.upb.mirestaurante_dondetono;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class EntradaActivity extends ListActivity {

    public class Entrada {
        private String nombreProducto;
        private String ingredientesProducto;
        private String precioProducto;

        private Integer imagenProducto;
    }
    private MyAdapter adaptador = null;
    private static ArrayList<Entrada> arregloProducto = new ArrayList<Entrada>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setDataEntrada();
        adaptador = new MyAdapter(this);
        setListAdapter (adaptador);
        Log.d("EntradaActivity", "Data set");
        //setContentView(R.layout.activity_entrada);
    }

    private void setDataEntrada(){
        arregloProducto.clear();

        Entrada productoActual1 = new Entrada();
        productoActual1.nombreProducto = this.getResources().getString(R.string.entrada1);
        productoActual1.ingredientesProducto = this.getResources().getString(R.string.ingentrada1);
        productoActual1.precioProducto = this.getResources().getString(R.string.pre_entrada1);
        productoActual1.imagenProducto = R.drawable.bruschettas;
        arregloProducto.add(productoActual1);

        Entrada productoActual2 = new Entrada();
        productoActual2.nombreProducto = this.getResources().getString(R.string.entrada2);
        productoActual2.ingredientesProducto = this.getResources().getString(R.string.ingentrada2);
        productoActual2.precioProducto = this.getResources().getString(R.string.pre_entrada2);
        productoActual2.imagenProducto = R.drawable.carpaccio;
        arregloProducto.add(productoActual2);

        Entrada productoActual3 = new Entrada();
        productoActual3.nombreProducto = this.getResources().getString(R.string.entrada3);
        productoActual3.ingredientesProducto = this.getResources().getString(R.string.ingentrada3);
        productoActual3.precioProducto = this.getResources().getString(R.string.pre_entrada3);
        productoActual3.imagenProducto = R.drawable.empandas;
        arregloProducto.add(productoActual3);


    }

    public static class MyAdapter extends BaseAdapter {
        private Context myContexto;

        public MyAdapter(Context c) {
            myContexto = c;
        }

        @Override
        public int getCount() {
            return arregloProducto.size();
        }

        @Override
        public Object getItem(int arg) {
            return arregloProducto.get(arg);
        }

        @Override
        public long getItemId(int arg) {
            return 0;
        }

        @Override
        public View getView(int position, View vista, ViewGroup arg2) {

            View view = null;
            if (vista == null) {
                LayoutInflater inflater = (LayoutInflater) myContexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.activity_entrada, null); // si producto se cerro lancelo nuevamente

            } else {
                view = vista;
            }
            ImageView imgProduc = (ImageView) view.findViewById(R.id.ImageViewProducto);
            imgProduc.setImageDrawable(myContexto.getResources().getDrawable(arregloProducto.get(position).imagenProducto));

            TextView nombreProducto = (TextView) view.findViewById(R.id.textViewProduc);
            nombreProducto.setText(arregloProducto.get(position).nombreProducto);

            TextView ingredientesProducto = (TextView) view.findViewById(R.id.textViewIngre);
            ingredientesProducto.setText(arregloProducto.get(position).ingredientesProducto);

            TextView PrecioProducto = (TextView) view.findViewById(R.id.TextViewPrecio);
            PrecioProducto.setText(arregloProducto.get(position).precioProducto);

            return view;
            // View view = convertView;
        }
    }

}