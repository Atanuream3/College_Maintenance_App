package com.example.asmita.loginactivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText user,pass;
    Button   login,clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Explode explode = new Explode();
        getWindow().setExitTransition(explode);
        Slide slide=new Slide(Gravity.RIGHT);
        getWindow().setReturnTransition(slide);
        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.loginbtn);
        clear = (Button) findViewById(R.id.buttonclear);
    }

    public void getLogin(View view)
    {
        final String username = user.getText().toString().trim();
        final String password = pass.getText().toString().trim();

        if(username.isEmpty() && password.isEmpty())
        {
            Toast.makeText(this,"Username and Password must be required.",Toast.LENGTH_LONG).show();
        }
        //Creating a string request
        else {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.LOGIN_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            //response.toString();
                            //If we are getting success from server
                            if (response.trim().equals(Config.LOGIN_SUCCESS)) {
                                //Creating a shared preference
                                SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);

                                //Creating editor to store values to shared preferences
                                SharedPreferences.Editor editor = sharedPreferences.edit();

                                //Adding values to editoroa
                                editor.putBoolean(Config.LOGGEDIN_SHARED_PREF, true);
                                editor.putString(Config.EMAIL_SHARED_PREF, username);

                                //Saving values to editor
                                editor.commit();

                                //Starting profile activity
                                Intent intent = new Intent(MainActivity.this, UserHome.class);
                                startActivity(intent);
                                Toast.makeText(MainActivity.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                                // User.setText(password);
                            } else {
                                //If the server response is not success
                                //Displaying an error message on toast
                                Toast.makeText(MainActivity.this, "Please enter username or password", Toast.LENGTH_LONG).show();
                                //User.setText(response);
                            }
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
                    params.put(Config.KEY_USER,username);
                    params.put(Config.KEY_PASSWORD,password);

                    //returning parameter
                    return params;
                }
            };

            //Adding the string request to the queue
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        }
    }

    public void startRegister(View view)
    {
        startActivity(new Intent(MainActivity.this,ProfileActivity.class));
    }

    public void clearData(View view)
    {
        user.setText("");
        pass.setText("");
    }
    }








