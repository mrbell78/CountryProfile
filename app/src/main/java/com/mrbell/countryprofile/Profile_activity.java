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
                break;case "Pakistan":
                txttitle.setText("Pakistan");
                img.setImageResource(R.drawable.alicon);
                txt1.setText(R.string.indiapro);
                break;
                case "Argentina":
                txttitle.setText("Argentina");
                img.setImageResource(R.drawable.argenitnah);
                txt1.setText(R.string.Argentina);
                break;
                case "Brazil":
                txttitle.setText("Brazil");
                img.setImageResource(R.drawable.brazilh);
                txt1.setText(R.string.Brazil);
                break;
                case "Belgium":
                txttitle.setText("Belgium");
                img.setImageResource(R.drawable.belgiumh);
                txt1.setText(R.string.Belgium);
                break;
            case "Chilie":
                txttitle.setText("Chilie");
                img.setImageResource(R.drawable.chiles_h);
                txt1.setText(R.string.chile);
                break;
            case "Iraq":
                txttitle.setText("Iraq");
                img.setImageResource(R.drawable.iraq_bagdadh);
                txt1.setText(R.string.iraq);
                break;
            case "Fizi":
                txttitle.setText("Fizi");
                img.setImageResource(R.drawable.fizi_h);
                txt1.setText(R.string.fizi);
                break;
            case "Canada":
                txttitle.setText("Canada");
                img.setImageResource(R.drawable.canada_h);
                txt1.setText(R.string.canada);
                break;
            case "Egypt":
                txttitle.setText("Egypt");
                img.setImageResource(R.drawable.egypt_h);
                txt1.setText(R.string.egypt);
                break;
            case "Crotia":
                txttitle.setText("Crotia");
                img.setImageResource(R.drawable.crotia_h);
                txt1.setText(R.string.croatia);
                break;
            case "Italy":
                txttitle.setText("Italy");
                img.setImageResource(R.drawable.italy_);
                txt1.setText(R.string.italy);
                break;
            case "England":
                txttitle.setText("England");
                img.setImageResource(R.drawable.england_h);
                txt1.setText(R.string.england);
                break;
            case "Usa":
                txttitle.setText("USA");
                img.setImageResource(R.drawable.usa_h);
                txt1.setText(R.string.usa);
                break;
                default:
                    return;

        }


        }


}
