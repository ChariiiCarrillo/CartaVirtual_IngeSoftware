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

public class BebidaActivity extends ListActivity {

    public class Bebida {
        private String nombreProducto;
        private String ingredientesProducto;
        private String precioProducto;

        private Integer imagenProducto;
    }

    private MyAdapter adaptador = null;
    private static ArrayList<Bebida> arregloProducto = new ArrayList<Bebida>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDataBebida();
        adaptador = new MyAdapter(this);
        setListAdapter (adaptador);
        Log.d("BebidaActivity", "Data set");
        //setContentView(R.layout.activity_bebida);
    }

    private void setDataBebida(){
        arregloProducto.clear();

        Bebida productoActualB1 = new Bebida();
        productoActualB1.nombreProducto = this.getResources().getString(R.string.Bebida1);
        productoActualB1.ingredientesProducto = this.getResources().getString(R.string.ingreB1);
        productoActualB1.precioProducto = this.getResources().getString(R.string.pre_B1);
        productoActualB1.imagenProducto = R.drawable.gaseosas;
        arregloProducto.add(productoActualB1);

        Bebida productoActualB2 = new Bebida();
        productoActualB2.nombreProducto = this.getResources().getString(R.string.Bebida2);
        productoActualB2.ingredientesProducto = this.getResources().getString(R.string.ingreB2);
        productoActualB2.precioProducto = this.getResources().getString(R.string.pre_B2);
        productoActualB2.imagenProducto = R.drawable.agua;
        arregloProducto.add(productoActualB2);

        Bebida productoActualB3 = new Bebida();
        productoActualB3.nombreProducto = this.getResources().getString(R.string.Bebida3);
        productoActualB3.ingredientesProducto = this.getResources().getString(R.string.ingreB3);
        productoActualB3.precioProducto = this.getResources().getString(R.string.pre_B3);
        productoActualB3.imagenProducto = R.drawable.sodasaborizadas;
        arregloProducto.add(productoActualB3);


    }

    public static class MyAdapter extends BaseAdapter {
        private Context myContexto;
        public MyAdapter(Context c){
            myContexto = c;
        }

        @Override
        public int getCount(){
            return arregloProducto.size();
        }
        @Override
        public Object getItem(int arg){
            return arregloProducto.get(arg);
        }
        @Override
        public long getItemId(int arg){
            return 0;
        }
        @Override
        public View getView(int position, View vista, ViewGroup arg2){

            View view = null;
            if (vista == null){
                LayoutInflater inflater = (LayoutInflater) myContexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.activity_entrada, null); // si producto se cerro lancelo nuevamente

            } else {
                view = vista;
            }
            ImageView imgProduc =(ImageView) view.findViewById(R.id.ImageViewProducto);
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