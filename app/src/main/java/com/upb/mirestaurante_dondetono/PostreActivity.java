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

public class PostreActivity extends ListActivity {

    public class Postre {
        private String nombreProducto;
        private String ingredientesProducto;
        private String precioProducto;

        private Integer imagenProducto;
    }

    private MyAdapter adaptador = null;
    private static ArrayList<Postre> arregloProducto = new ArrayList<Postre>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDataPostre();
        adaptador = new MyAdapter(this);
        setListAdapter (adaptador);
        Log.d("PostreActivity", "Data set");
        //setContentView(R.layout.activity_producto);
    }

    private void setDataPostre(){
        arregloProducto.clear();

        Postre productoActualP1 = new Postre();
        productoActualP1.nombreProducto = this.getResources().getString(R.string.Postre1);
        productoActualP1.ingredientesProducto = this.getResources().getString(R.string.ingreP1);
        productoActualP1.precioProducto = this.getResources().getString(R.string.pre_P1);
        productoActualP1.imagenProducto = R.drawable.browniehelado;
        arregloProducto.add(productoActualP1);

        Postre productoActualP2 = new Postre();
        productoActualP2.nombreProducto = this.getResources().getString(R.string.Postre2);
        productoActualP2.ingredientesProducto = this.getResources().getString(R.string.ingreP2);
        productoActualP2.precioProducto = this.getResources().getString(R.string.pre_P2);
        productoActualP2.imagenProducto = R.drawable.fresascrema;
        arregloProducto.add(productoActualP2);

        Postre productoActualP3 = new Postre();
        productoActualP3.nombreProducto = this.getResources().getString(R.string.Postre3);
        productoActualP3.ingredientesProducto = this.getResources().getString(R.string.ingreP3);
        productoActualP3.precioProducto = this.getResources().getString(R.string.pre_P3);
        productoActualP3.imagenProducto = R.drawable.galletaconhelado;
        arregloProducto.add(productoActualP3);


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