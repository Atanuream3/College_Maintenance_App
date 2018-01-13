package com.example.asmita.loginactivity;

/**
 * Created by asmita on 18/4/17.
 */

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by IT on 4/15/2017.
 */

public class MySingleton {

    private static MySingleton minstance;
    private RequestQueue requestQueue;
    private static Context mctx;


    private MySingleton(Context context)
    {
        mctx=context;
        requestQueue=getRequestQueue();
    }

    public static synchronized MySingleton getInstance(Context context)
    {
        if (minstance==null)
        {
            minstance=new MySingleton(context);
        }
        return minstance;
    }

    public RequestQueue getRequestQueue()
    {
        if(requestQueue==null)
        {
            requestQueue= Volley.newRequestQueue(mctx.getApplicationContext());
        }
        return requestQueue;
    }

    public void addTorequest(Request request)
    {
        requestQueue.add(request);

    }

}
