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

        videoview = (VideoView) findViewById(R.id.vd);


        String ruta = "android. resource://" + getPackageName() + "/" + R.raw.video;  // Ruta del video

        Uri uri = Uri.parse(ruta);
        videoview.setVideoURI(uri);

        // Control de navigacion

        MediaController media = new MediaController(this);
        videoview.setMediaController(media);
    }
}
