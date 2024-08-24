package com.upb.mirestaurante_dondetono;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void abrirMenu (View v){
        Intent i; //intent : forma en la que se comunican las clases
        i= new Intent(this, MenuActivity.class); //(actividad actual , a donde quiere ir)
        startActivity(i); //lanzar la actividad
    }

    public void abrirSede (View v){
        Intent i; //intent : forma en la que se comunican las clases
        i= new Intent(this, MapsActivity.class); //(actividad actual , a donde quiere ir)
        startActivity(i); //lanzar la actividad
    }

    public void abrirReserva (View v){

        String whatsApp = "com.whatsapp";
        PackageManager pm = getPackageManager(); //administrador de paquetes
        Intent i = pm.getLaunchIntentForPackage(whatsApp);
        startActivity(i);
    }
    public void abrirPedido (View v){
        //Intent i; //intent : forma en la que se comunican las clases
        //i= new Intent(this, PedidoActivity.class); //(actividad actual , a donde quiere ir)
        //startActivity(i); //lanzar la actividad
        String whatsApp = "com.whatsapp";
        PackageManager pm = getPackageManager(); //administrador de paquetes
        Intent i = pm.getLaunchIntentForPackage(whatsApp);
        startActivity(i);
    }
}