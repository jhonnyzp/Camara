package com.example.panda.camara;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class Galeria extends AppCompatActivity {

    private ListView lv1;
    private ImageButton iv1;
    private String[] archivos;
    private ArrayAdapter<String> adaptador1;
    private Bitmap bitmap1;
    private byte[] byteArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);

        File dir=getExternalFilesDir(null);
        archivos=dir.list();
        adaptador1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,archivos);
        lv1=(ListView)findViewById(R.id.listView1);
        lv1.setAdapter(adaptador1);

        iv1=(ImageButton)findViewById(R.id.iv1);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                bitmap1 = BitmapFactory.decodeFile(getExternalFilesDir(null)+"/"+archivos[arg2]);
                iv1.setImageBitmap(bitmap1);

                Bitmap bmp = BitmapFactory.decodeFile(getExternalFilesDir(null)+"/"+archivos[arg2]);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byteArray = stream.toByteArray();
            }});

    }
    public void imagencompleta (View view){
        Intent i = new Intent(this, ImagenCompleta.class );
        i.putExtra("picture", byteArray);
        i.putExtra("llugar", archivos);
        startActivity(i);



    }
}