package com.example.asmita.loginactivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class MainProfileActivity extends AppCompatActivity implements View.OnClickListener {




    private Button logoutm;
    private ImageButton viewmap;
    private ImageButton callone,messageone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile);
        callone=(ImageButton)findViewById(R.id.callone);
        messageone=(ImageButton)findViewById(R.id.messageone);
        viewmap=(ImageButton)findViewById(R.id.viewmap) ;
        logoutm=(Button)findViewById(R.id.logout);
        messageone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainProfileActivity.this,MessageActivity.class);
                startActivity(intent);
            }
        });
        callone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainProfileActivity.this,call.class);
                startActivity(in);
            }
        });

        logoutm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout=new Intent(MainProfileActivity.this,MainActivity.class);
                startActivity(logout);
            }
        });
        viewmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainProfileActivity.this,MapsActivity.class);startActivity(in);
            }
        });


    }




        @Override
        public void onClick (View v){

        }
    }


