package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import Classes.Precio;

public class Clientes_act extends AppCompatActivity {

    private Spinner spin1, spin2;
    private EditText edit;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        spin1 = (Spinner) findViewById(R.id.sp1);
        spin2 = (Spinner) findViewById(R.id.sp2);
        edit = (EditText) findViewById(R.id.ed1);
        text = (TextView) findViewById(R.id.tv);


        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaProductos = (ArrayList<String>) getIntent().getSerializableExtra("listaProductos");


        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);

        ArrayAdapter<String> adapts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaProductos);

        spin1.setAdapter(adapt);
        spin2.setAdapter(adapts);
    }

    public void Calcular(View v) {

        String cliente = spin1.getSelectedItem().toString();
        String producto = spin2.getSelectedItem().toString();


        Precio pc = new Precio();
        if (cliente.equals("Patricio") && producto.equals("Audifono")) {
            text.setText("El monto  es:" + pc.getAudifono());

        } else if (cliente.equals("Patricio") && producto.equals("Mouse"))
            text.setText("El munto es:" + pc.getMouse());

        else if (cliente.equals("Benjude") && producto.equals("Mouse")) {
            text.setText("El monto es :" + pc.getMouse());
        } else if (cliente.equals("Benjude") && producto.equals("Audifono"))
            text.setText("El monto es:" + pc.getAudifono());
          else {
            text.setText("wouf!No hay otro monto.");
        }
    }
}






