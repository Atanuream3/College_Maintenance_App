package com.example.asmita.loginactivity;

import android.Manifest;

import android.content.pm.PackageManager;

import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {
    EditText et1, et3;

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        et1 = (EditText) findViewById(R.id.et1);

        et3 = (EditText) findViewById(R.id.et3);


    }

    public void Message(View view) {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling


            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},
                    MY_PERMISSIONS_REQUEST_SEND_SMS);
            return;
        }

        SmsManager smsManager = SmsManager.getDefault();
        String number = "8624002739";
        String des_name = et1.getText().toString();

        String des_phone = et3.getText().toString();


        String msg = "Mr/Mrs " + des_name + " having problem of " + "" + des_phone;
        Toast.makeText(getApplicationContext(), "Thank you for sending message ", Toast.LENGTH_LONG).show();
        smsManager.sendTextMessage(number, null, msg, null, null);


    }


}