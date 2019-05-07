package com.mrbell.countryprofile;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button bdbtn,pakbtn,indiabtn;
    private Intent intt;
    private RecyclerView rv;
    private ArrayList<CountryData>list;
    private int[]img;
    private String[]name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv);
        img= new int[]{R.drawable.bangladesh, R.drawable.india, R.drawable.pakistan,
                R.drawable.argentina, R.drawable.brazil,R.drawable.belgium,R.drawable.chile,R.drawable.iraq,R.drawable.fizi,
        R.drawable.canada,R.drawable.egypt,R.drawable.croetia,R.drawable.italy,R.drawable.england,R.drawable.usa};
        name=getResources().getStringArray(R.array.country);

        CountryData cd = new CountryData(img, name);
        list=new ArrayList<>();
        list.add(cd);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        rv.addItemDecoration(new DividerItemDecoration(rv.getContext(), DividerItemDecoration.VERTICAL));
        rv.setLayoutManager(manager);
        CustomAdapter adapter = new CustomAdapter(this,img,name);
        rv.setAdapter(adapter);

    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder albuilder = new AlertDialog.Builder(MainActivity.this);

        albuilder.setIcon(R.drawable.alicon);
        albuilder.setTitle(R.string.altitle);
        albuilder.setMessage(R.string.almasg);
        albuilder.setCancelable(false);

        albuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();

            }
        });

        albuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = albuilder.create();

        alertDialog.show();

    }
}
