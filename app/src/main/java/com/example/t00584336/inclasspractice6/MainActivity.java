package com.example.t00584336.inclasspractice6;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends Activity {

    //next in class practice (icp)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //next icp
        webView = findViewById(R.id.webview);

        String json = loadJSONFromAsset();
        //Log.v("potato", "Read json file: " + json);
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i=0; i < jsonArray.length();i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Log.v("potato", "Actual Tree Name: " + jsonObject.get("id") + " " + jsonObject.get("name"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //next icp method
    public void go (View view)
    {
        webView.loadUrl("https://tru.ca");
        webView.setWebViewClient(new WebViewClient());
    }


    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("trees.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}

//All modifications to the layout are part of the next in class practice