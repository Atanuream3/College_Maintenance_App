package com.example.asmita.loginactivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class AdminHome extends AppCompatActivity {


    public ProgressDialog loadimage;
    Button accept1,reject1,logout1;
    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        accept1 = (Button) findViewById(R.id.accept);
        reject1= (Button) findViewById(R.id.rejectbtn);
        logout1 = (Button) findViewById(R.id.logout);
        loadimage = ProgressDialog.show(this, "Fetching...", "Please wait...", false, false);
        imageview = (ImageView) findViewById(R.id.imageview);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.gettimage,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(AdminHome.this,response,Toast.LENGTH_LONG).show();
                        Picasso.with(getApplicationContext()).load(response).into(imageview);
                        loadimage.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
                        //You can handle error here if you want
                        //Toast.makeText(this,"error",Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //Adding parameters to request
                return params;
            }
        };

        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }








    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Toast.makeText(this,"Press again",Toast.LENGTH_LONG).show();
        Toast.makeText(this,"Press again to exit",Toast.LENGTH_LONG).show();
        AlertDialog dialog = builder.create();
        dialog.show();
        finish();
        dialog.setMessage("Hello Friends");

    }

    public void accept(View view)
    {
            ProgressDialog bar = ProgressDialog.show(this,"Processing" ,"please wait...",false,false);
          Toast.makeText(AdminHome.this,"Image Accepted",Toast.LENGTH_LONG).show();
        bar.dismiss();
    }
    public void reject()
    {
        ProgressDialog bar=ProgressDialog.show(this,"Processing","Please wait....",false,false);
        Toast.makeText(AdminHome.this,"Image Rejected",Toast.LENGTH_LONG).show();
        bar.dismiss();
    }
    public void logout(View view)
    {
        startActivity(new Intent(this,AdminLogin.class));
    }

}
