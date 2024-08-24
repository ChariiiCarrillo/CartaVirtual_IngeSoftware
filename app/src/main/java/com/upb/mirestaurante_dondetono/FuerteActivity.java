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

public class FuerteActivity extends ListActivity {

    public class Fuerte{
        private String nombreProducto;
        private String ingredientesProducto;
        private String precioProducto;

        private Integer imagenProducto;
    }

    private MyAdapter adaptador = null;
    private static ArrayList<Fuerte> arregloProducto = new ArrayList<Fuerte>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDataFuerte();
        adaptador = new MyAdapter(this);
        setListAdapter (adaptador);
        Log.d("FuerteActivity", "Data set");
        //setContentView(R.layout.activity_producto);
    }

    private void setDataFuerte(){
        arregloProducto.clear();

        Fuerte productoActualF1 = new Fuerte();
        productoActualF1.nombreProducto = this.getResources().getString(R.string.Fuerte1);
        productoActualF1.ingredientesProducto = this.getResources().getString(R.string.ingreF1);
        productoActualF1.precioProducto = this.getResources().getString(R.string.pre_F1);
        productoActualF1.imagenProducto = R.drawable.pastacarbonara;
        arregloProducto.add(productoActualF1);

        Fuerte productoActualF2 = new Fuerte();
        productoActualF2.nombreProducto = this.getResources().getString(R.string.Fuerte2);
        productoActualF2.ingredientesProducto = this.getResources().getString(R.string.ingreF2);
        productoActualF2.precioProducto = this.getResources().getString(R.string.pre_F2);
        productoActualF2.imagenProducto = R.drawable.lasana;
        arregloProducto.add(productoActualF2);

        Fuerte productoActualF3 = new Fuerte();
        productoActualF3.nombreProducto= this.getResources().getString(R.string.Fuerte3);
        productoActualF3.ingredientesProducto = this.getResources().getString(R.string.ingreF3);
        productoActualF3.precioProducto = this.getResources().getString(R.string.pre_F3);
        productoActualF3.precioProducto = this.getResources().getString(R.string.pre_F3_1);
        productoActualF3.precioProducto = this.getResources().getString(R.string.pre_F3_2);
        productoActualF3.imagenProducto = R.drawable.pizza;
        arregloProducto.add(productoActualF3);


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