package com.mrbell.countryprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    private EditText edtEmail,edtPassword;
    private Button btnLogin;
    private TextView registertv;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db=new DatabaseHelper(this);
        initialize();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=edtEmail.getText().toString();
                String password= edtPassword.getText().toString();

                Boolean chekmail= db.passwordmail(mail,password);
                if(chekmail==true){
                    Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    int i=1;
                    startActivity(new Intent(getApplicationContext(),MainActivity.class).putExtra("flag",i));
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registertv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            }
        });
    }

    private void initialize() {

        edtEmail=findViewById(R.id.edt_mail);
        edtPassword=findViewById(R.id.edt_password);
        btnLogin=findViewById(R.id.login);
        registertv=findViewById(R.id.createRegistertv);
    }
}
