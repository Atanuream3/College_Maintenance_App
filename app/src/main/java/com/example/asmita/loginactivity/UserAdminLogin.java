package com.example.asmita.loginactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserAdminLogin extends AppCompatActivity {

    Button admin,user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_admin_login);
        admin = (Button) findViewById(R.id.btnadmin);
        user = (Button) findViewById(R.id.btnuser);
    }
    public void adminLogin(View view)
    {
        startActivity(new Intent(this,AdminLogin.class));
    }

    public void userLogin(View view)
    {
        startActivity(new Intent(this,MainActivity.class));
    }


    }

