package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Classes.AdminSQLiteOpenHelper;

public class Productos_act extends AppCompatActivity {
    // Declaraciones de datos

    private EditText edcodigo,ednombre,edprecio,edstock;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_act);

        // Aqui llomo lo elementos por id

        edcodigo =(EditText)findViewById(R.id.edit_codigo);
        ednombre =(EditText)findViewById(R.id.edit_nombre);
        edprecio  =(EditText)findViewById(R.id.edit_precio);
        edstock   =(EditText)findViewById(R.id.edit_stock);

    }

    // M etos  para permitir guardar productos en mi base de datos
    public void Anadirprductos(View v) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase(); // Permite la sobreescritura en mi base de datos.


        if (!edcodigo.getText().toString().isEmpty()) {

            // .. añades el producto

            ContentValues registro = new ContentValues();

            registro.put("codigo", edcodigo.getText().toString());
            registro.put("nombre", ednombre.getText().toString());
            registro.put("precio", edprecio.getText().toString());
            registro.put("stock", edstock.getText().toString());

            bd.insert("productos", null, registro);
            bd.close();


            Toast.makeText(this, "Has guardado un producto.", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(this, "Debe rellenar los campos .", Toast.LENGTH_SHORT).show();
        }
    }
    public void Mostrarproductos(View v){
        AdminSQLiteOpenHelper  admin = new AdminSQLiteOpenHelper(this,"fichero",null,1);
        SQLiteDatabase db=  admin.getWritableDatabase();

        String codigo= edcodigo.getText().toString();

        if(!codigo.isEmpty()) {
            Cursor fila = db.rawQuery("SELECT nombre, precio,stock FROM productos WHERE codigo=" + codigo, null);

            if (fila.moveToFirst()) {
                ednombre.setText(fila.getString(0));
                edprecio.setText(fila.getString(1));
                edstock.setText(fila.getString(2));

            } else {
                Toast.makeText(this, "No hay campo en la tabla", Toast.LENGTH_SHORT).show();
            }
          }else
              {
                  Toast.makeText(this,"No hay producto asociado al codigo", Toast.LENGTH_SHORT).show();
            }
            }



    public void Eliminarproductos(View v){

        AdminSQLiteOpenHelper  admin = new AdminSQLiteOpenHelper(this,"fichero",null,1);
        SQLiteDatabase db=  admin.getWritableDatabase();

        String codigo= edcodigo.getText().toString();
        db.delete("productos","codigo="+codigo,null);
        db.close();
        Toast.makeText(this,"Has eliminado un producto.",Toast.LENGTH_SHORT).show();
    }
    public void Actualizarproductos(View v){
        AdminSQLiteOpenHelper  admin = new AdminSQLiteOpenHelper(this,"fichero",null,1);
        SQLiteDatabase db=  admin.getWritableDatabase();

        String codigo= edcodigo.getText().toString();

        ContentValues cont = new ContentValues();

        cont.put("codigo",edcodigo.getText().toString());
        cont.put("nombre",ednombre.getText().toString());
        cont.put("precio",edprecio.getText().toString());
        cont.put("stock",edstock.getText().toString());

        if(!codigo.isEmpty())
        {
            db.update("productos", cont,"codigo="+codigo,null);

            Toast.makeText(this,"Has actualizado un campo",Toast.LENGTH_SHORT ).show();

        }
        }
        }