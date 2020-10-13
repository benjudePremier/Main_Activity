package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class home_act extends AppCompatActivity {
    private ViewFlipper viewf;
    private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);

        viewf = (ViewFlipper) findViewById(R.id.slider);

        for (int i = 0; i < images.length; i++) {
            flip_image(images[i]);
        }
    }


    // función que me permitirá configurar el slider
    public void flip_image(int i) {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        viewf.addView(view);           // añadimos al viewflipper el contenido del slider
        viewf.setFlipInterval(2800);   // duración intervalo de imagenes
        viewf.setAutoStart(true);     // inicia de forma automatica.

        // Sentido al slider
        viewf.setInAnimation(this, android.R.anim.slide_in_left);
        viewf.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public void maps(View v) {

        Intent i = new Intent(this, maps_act.class);
        startActivity(i);
    }

    public void Info(View v){
        Intent i  = new Intent(this,Info_act.class);
        startActivity(i);
    }
}
