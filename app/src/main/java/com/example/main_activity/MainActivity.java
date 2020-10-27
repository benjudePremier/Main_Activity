package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progress;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = (ProgressBar) findViewById(R.id.pb);
        bt = (Button) findViewById(R.id.btn);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Task().execute();// ejecuta mi tarea asíncrona.
            }
        });


        progress.setVisibility(View.INVISIBLE); // desaparece el elemento.
    }


    // Tarea Asíncrona.

    class Task extends AsyncTask<String, Void, String> {

        @Override  // Vamos a darle la configuración inicial a la tarea
        protected void onPreExecute() {

            progress.setVisibility(View.VISIBLE);
        }


        @Override // vamos a emplear el proceso o tarea pesada en segundo plano.
        protected String doInBackground(String... strings) {

            for (int i = 1; i < 10; i++) {
                try {
                    Thread.sleep(1000);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }


        @Override // finalizamos la tarea
        protected void onPostExecute(String s) {

            progress.setVisibility(View.INVISIBLE);

            Intent i = new Intent(getBaseContext(), home_act.class);
            startActivity(i);
        }
    }

    public void INICIAR(View v) {
        Intent i = new Intent(this, home_act.class);
        startActivity(i);

    }
}

