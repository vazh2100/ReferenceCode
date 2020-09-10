package com.vazheninapps.stringadvanced;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* setContentView(R.layout.activity_main);
        String stringName = "Андрей, Алексей, Павел, Михаил";
        String[] names = stringName.split(", ");
        for (String name: names) {
            Log.i("MyName", name );}*/
       /*String geometry = "Геометрия";
       String metr = geometry.substring(3, 7);
        Log.i("MyName", metr );*/
       /*String river = "Mississippi";
       Pattern pattern = Pattern.compile("Mi(.*?)pi");
       Matcher matcher = pattern.matcher(river);
       while (matcher.find()) {
           Log.i("MyName", matcher.group(1));
       } */


       String url = "<img src=\"http://cdn.posh24.se/images/:profile/0c5e670fdc6c774862ae847ab5b115367\" alt=\"Rihanna\"/>";
       Pattern patternImgURL = Pattern.compile("<img src=\"(.*?)\" alt=");
       Pattern patternName = Pattern.compile("alt=\"(.*?)\"");
       Matcher matcherImgURL = patternImgURL.matcher(url);
       Matcher matcherName = patternName.matcher(url);

        while (matcherImgURL.find()) {
            Log.i("MyName", matcherImgURL.group(1));}

        while (matcherName.find()) {
            Log.i("MyName", matcherName.group(1));}



    }
}
