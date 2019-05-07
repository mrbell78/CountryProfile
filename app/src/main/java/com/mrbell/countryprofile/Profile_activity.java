package com.mrbell.countryprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile_activity extends AppCompatActivity {
    private ImageView img;
    private TextView txt1,txttitle;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);

        img= (ImageView) findViewById(R.id.img1);
        txt1= (TextView) findViewById(R.id.tv21);
        txttitle=findViewById(R.id.tv_title);
        Intent intent =getIntent();

        Bundle bnd= intent.getExtras();

        name=bnd.getString("data");

        switch (name) {
            case "Bangladesh":
                txttitle.setText("Bangladesh");
                img.setImageResource(R.drawable.svaban);
                txt1.setText(R.string.bdpro);
                break;
            case "India":
                txttitle.setText("India");
                img.setImageResource(R.drawable.tajmagal);
                txt1.setText(R.string.indiapro);
                break;
        }


        }


}
