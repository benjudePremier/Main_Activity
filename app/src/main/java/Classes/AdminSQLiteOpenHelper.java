package Classes;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class AdminSQLiteOpenHelper  extends SQLiteOpenHelper{


    // Constructor de mi base de datos.

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // onCreate : Define la configuracion inicial de mi base de datos.
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE productos(codigo int Primary key, nombre text, precio float, stock int)");

    }

    // onUpgrade: Me permite realizar cambios esquematicos  de mi base de datos.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
