package com.example.panda.camara;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class Confirmar extends AppCompatActivity {

    private TextView c_ciudad;
    private ImageView c_foto;
    private RatingBar star;
    private EditText et_comentario;

    static String numero;
    static int n;

    Intent data;

    private String lugar,ran,comentario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);

        c_ciudad = (TextView)findViewById(R.id.c_ciudad);
        star = (RatingBar) findViewById(R.id.ratingBar);
        et_comentario = (EditText)findViewById(R.id.et_comentario);

        c_foto = (ImageView)findViewById(R.id.c_foto);

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);///TOMA FOTO
        int ranking = star.getNumStars();
        Bundle bundle = getIntent().getExtras();
        String dato=bundle.getString("lugar");

        c_ciudad.setText(dato);
        lugar = c_ciudad.getText().toString();
        ran = Integer.toString(ranking);
        comentario = et_comentario.getText().toString();

        numero = Integer.toString(n);
        n=n+1;
        File foto = new File(getExternalFilesDir(null), dato+numero);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(foto));

        Bundle extras = takePictureIntent.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get(dato+n);

        c_foto.setImageBitmap(imageBitmap);
        startActivity(takePictureIntent);
}
    public void cancelar(View view){
        Intent i = new Intent(this, MainActivity.class );
        et_comentario.setText("");
        star.setNumStars(0);
        startActivity(i);
    }
    public void publicar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put("lugar", c_ciudad.getText().toString()+n);
        registro.put("ciudad", lugar);
        registro.put("ran", ran);
        registro.put("comentario", comentario);
        bd.insert("ciudades1", null, registro);
        bd.close();

        Toast.makeText(this, "Se cargaron los datos de este lugar....gracias por compartir !",
        Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, MainActivity.class );
        startActivity(i);
    }
}
