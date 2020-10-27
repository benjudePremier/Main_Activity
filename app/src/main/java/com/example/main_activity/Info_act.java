package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;


import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Info_act extends AppCompatActivity {

    private VideoView videoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);

        // Aqui llamo el elemento por id
        videoview = (VideoView) findViewById(R.id.vd);

        videoview.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.s1)); // ruta del video
        // control de la navigacion
        MediaController media = new MediaController(this);
        videoview.setMediaController(media);
        videoview.start();
     }
   }
















