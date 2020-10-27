package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class home_act extends AppCompatActivity {
    private ViewFlipper fliper;
    private int[] images = {R.drawable.a, R.drawable.c, R.drawable.d};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);

        fliper = (ViewFlipper) findViewById(R.id.slider);

        for (int i = 0; i < images.length; i++) {
            flip_image(images[i]);
        }
    }
    // función que me permitirá configurar el slider
    public void flip_image(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        fliper.addView(view);           // añadimos al viewflipper el contenido del slider
        fliper.setFlipInterval(2800);   // duración intervalo de imagenes
        fliper.setAutoStart(true);     // inicia de forma automatica.

        // Sentido al slider
        fliper.setInAnimation(this, android.R.anim.slide_in_left);
        fliper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public void maps(View v) {

        Intent i = new Intent(this, maps_act.class);
        startActivity(i);
    }

    public void Info(View v){
        Intent i  = new Intent(this,Info_act.class);
        startActivity(i);
    }

    public void Negocio(View v){
        Intent i  = new Intent(this,Productos_act.class);
        startActivity(i);
    }

    public void Clientes(View v){

        ArrayList<String> listaClientes  = new ArrayList<String>();
        ArrayList<String> listaProductos  = new ArrayList<String>();

        listaClientes.add("Patricio");
        listaClientes.add("Benjude");

        listaProductos.add("Audifono");
        listaProductos.add("Mouse");

        Intent i = new Intent(this,Clientes_act.class);
        i.putExtra("listaClientes", listaClientes);
        i.putExtra("listaProductos",listaProductos);
        startActivity(i);
    }
}
