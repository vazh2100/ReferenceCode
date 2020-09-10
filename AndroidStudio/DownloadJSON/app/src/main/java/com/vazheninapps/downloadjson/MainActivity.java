package com.vazheninapps.downloadjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DownloadJSON task = new DownloadJSON();
        task.execute("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");

    }

    private static class DownloadJSON extends AsyncTask <String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            URL url = null;
            HttpURLConnection urlConnection = null;
            StringBuilder result = new StringBuilder();
            try {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();
                while (line!=null) {
                    result.append(line);
                    line = reader.readLine();
                }
                return result.toString();



             } catch (MalformedURLException e) {
                e.printStackTrace();
                Log.i("MyResult", e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                Log.i("MyResult", e.getMessage());
            } finally {
                if(urlConnection!= null) {urlConnection.disconnect();}
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONObject jsonObject = new JSONObject(s);
               /*String name = jsonObject.getString("name");
              JSONObject main = jsonObject.getJSONObject("main");
              String temp = main.getString("temp");
              String pressure = main.getString("pressure");
               Log.i("MyResult", name + " " + temp + " " + pressure);*/
                JSONArray jsonArray = jsonObject.getJSONArray("weather");
               JSONObject weather =  jsonArray.getJSONObject(0);
               String main = weather.getString("main");
               String description = weather.getString("description");
               Log.i("MyResult", main + " " + description);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
