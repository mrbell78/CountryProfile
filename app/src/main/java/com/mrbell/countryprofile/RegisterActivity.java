package com.mrbell.countryprofile;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText edt_email,edtPassword,edtConfirm_password;
    private Button btn_CreateAccount;
    private TextView loginaccount;

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initialization();
        db= new DatabaseHelper(this);

        btn_CreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=edt_email.getText().toString();
                String password=edtPassword.getText().toString();
                String confirmpass=edtConfirm_password.getText().toString();

                if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(confirmpass)){

                    if(password.equals(confirmpass)){

                        Boolean checkmail= db.chekmail(email);
                        if(checkmail==true){
                             db.insert(email,password);
                            Toast.makeText(RegisterActivity.this, "regsistratrion successbul", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                            finish();
                        }else{
                            Toast.makeText(RegisterActivity.this, "this "+ email+ "Already exist", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(RegisterActivity.this, "password doesnt match", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(RegisterActivity.this, "Enter all the filed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        loginaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });


    }

    private void initialization() {
        edt_email=findViewById(R.id.edt_mail);
        edtPassword=findViewById(R.id.edt_password);
        edtConfirm_password=findViewById(R.id.edt_Confirmpassword);
        loginaccount=findViewById(R.id.login_account);
        btn_CreateAccount=findViewById(R.id.Createaccount);
    }

}
