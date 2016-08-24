package com.example.panda.camara;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ImagenCompleta extends AppCompatActivity {

    private TextView tv_nombrecompleto,tv_comentarioscompleto;

    private ImageButton im_imagencompleta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen_completa);

        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("picture");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        ImageButton image = (ImageButton) findViewById(R.id.im_imagencompleta);
        image.setImageBitmap(bmp);

       AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        Bundle bundle = getIntent().getExtras();
        String dato=bundle.getString("llugar");

        Cursor fila = bd.rawQuery("select ciudad,ranking,comentario from ciudades1 where lugar='" + dato +"'", null);
        if (fila.moveToFirst()) {
            //et1.setText(fila.getString(0));
            //et3.setText(fila.getString(1));
        } else
            Toast.makeText(this, "No existe un artículo con dicha descripción",
                    Toast.LENGTH_SHORT).show();
        bd.close();

    }
}
