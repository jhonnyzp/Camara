package com.example.panda.camara;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    //private ImageView imagen1;
    //private EditText et_ciudad;
    //private Spinner ciudad;
    private ImageButton im_foto;

    private final String ruta_fotos = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/misfotos/";
    private File file = new File(ruta_fotos);

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private String name = "";

//    Intent takePictureIntent ;File mi_foto;Uri uri;

    private Spinner spinner1;
    private EditText et1,et2;
    private TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        file.mkdirs();
        //et_ciudad=(EditText)findViewById(R.id.et_ciudad);
        im_foto = (ImageButton)findViewById(R.id.im_foto);

        spinner1 = (Spinner) findViewById(R.id.spinner);
        String []opciones={"¡Elije tu ciudad!"," ","Manta","Baños","Cuenca","Guayaquil"};
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);
    }
    public void tomarfoto(View view){

        String selec=spinner1.getSelectedItem().toString();

        if (selec.equals("Manta")) {
            Intent i = new Intent(this, Confirmar.class );
            i.putExtra("lugar", selec);
            startActivity(i);
        } else
        if (selec.equals("Baños")) {
            Intent i = new Intent(this, Confirmar.class );
            i.putExtra("lugar", selec);
            startActivity(i);
        }
        else
        if (selec.equals("Cuenca")) {
            Intent i = new Intent(this, Confirmar.class );
            i.putExtra("lugar", selec);
            startActivity(i);
        }
        else
        if (selec.equals("Guayaquil")) {
            Intent i = new Intent(this, Confirmar.class );
            i.putExtra("lugar", selec);
            startActivity(i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mi, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void galeria(View view) {
        Intent i = new Intent(this, Galeria.class );
        startActivity(i);
    }
    public void gps(View view) {
        Intent i = new Intent(this, Gps.class );
        startActivity(i);
    }
}
