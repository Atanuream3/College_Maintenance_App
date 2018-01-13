package com.example.asmita.loginactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class ProfileActivity extends AppCompatActivity {
    EditText user,pass,retype,mob;
    Button register,clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        user= (EditText) findViewById(R.id.editTextunname);
        pass= (EditText) findViewById(R.id.editTextpass);
        retype= (EditText) findViewById(R.id.editTextrepass);
        mob = (EditText) findViewById(R.id.editTextmobno);
        register = (Button) findViewById(R.id.buttonreg);
        clear = (Button) findViewById(R.id.buttonclear);

    }

    public void registerUser(View view) {


        final String username = user.getText().toString().trim();
        final String password = pass.getText().toString().trim();
        final String retypass = retype.getText().toString().trim();
        final String mobno = mob.getText().toString().trim();

        if (username.isEmpty() && password.isEmpty() && retypass.isEmpty() && mobno.isEmpty()) {
            Toast.makeText(this, "Please fill all the Fields", Toast.LENGTH_LONG).show();
        } else if (pass.length() < 4) {
            Toast.makeText(this, "Password length should be greater than 4", Toast.LENGTH_LONG).show();

        } else if (mobno.length() > 10 || mobno.length() < 10) {
            Toast.makeText(this, "Mob No should be 10 Digit", Toast.LENGTH_LONG).show();
        }
        else {


            try {
                if (password.equals(retypass)) {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.INSERT_URL,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    //response.toString();
                                    //If we are getting success from server
                                    if (response.trim().equals(Config.INSERT_SUCCESS)) {
                                        //Creating a shared preference
                                        //SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);

                                        //Creating editor to store values to shared preferences
                                        //SharedPreferences.Editor editor = sharedPreferences.edit();

                                        //Adding values to editor
                                        //editor.putBoolean(Config.LOGGEDIN_SHARED_PREF, true);
                                        //editor.putString(Config.EMAIL_SHARED_PREF, username);

                                        //Saving values to editor
                                        //editor.commit();

                                        //Starting profile activity
                                        //Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                                        //startActivity(intent);
                                        // User.setText(password);

                                        Toast.makeText(ProfileActivity.this, "Successfully Registered", Toast.LENGTH_LONG).show();
                                        startActivity(new Intent(ProfileActivity.this, MainActivity.class));


                                    } else {
                                        //If the server response is not success
                                        //Displaying an error message on toast
                                        Toast.makeText(ProfileActivity.this, response, Toast.LENGTH_LONG).show();
                                        //User.setText(response);
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                                    //You can handle error here if you want
                                    //Toast.makeText(this,"error",Toast.LENGTH_SHORT).show();
                                }
                            }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            //Adding parameters to request
                            params.put(Config.KEY_USER, username);
                            params.put(Config.KEY_PASSWORD, password);
                            params.put(Config.KEY_MOBNO, mobno);

                            //returning parameter
                            return params;
                        }
                    };

                    //Adding the string request to the queue
                    RequestQueue requestQueue = Volley.newRequestQueue(this);
                    requestQueue.add(stringRequest);
                } else {
                    Toast.makeText(ProfileActivity.this, "Password doesn't match", Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {
                Toast.makeText(ProfileActivity.this, "error occured", Toast.LENGTH_LONG).show();


            }
        }
    }

    public void clearField(View view)
    {
        user.setText("");
        pass.setText("");
        retype.setText("");
        mob.setText("");
    }
}
