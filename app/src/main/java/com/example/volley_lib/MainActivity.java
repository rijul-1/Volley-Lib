package com.example.volley_lib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView txt = findViewById(R.id.textview);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=a1e27e66dfe547a1991a8dcc9224bdc5";
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("length","length of response is "  + response);
//                    JSONObject jsonObject = response.getJSONObject("articles");
//                    for(int i = 0 ; i<jsonArray.length() ; i++){
//                        JSONObject news = jsonArray.getJSONObject(i);
//                        Log.d("news ",news.getString("author"));
//                    }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                txt.setText("something went wrong");
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}