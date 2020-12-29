package com.qbielka.dinazeng.choose_your_own_adventure.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import com.qbielka.dinazeng.choose_your_own_adventure.R;
import com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects.Story;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;

public class LauncherActivity extends AppCompatActivity {

    ArrayList <Story> storyArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        try {
            todo();
        } catch (IOException e){
            // todo????
            // I have no solution for what happens right now the app essentially needs to crash
        }
        startActivity(intent);
    }

    private void todo() throws IOException {
        final Resources resources =  getResources();
        InputStream inputStream = resources.openRawResource(R.raw.StoryInput);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                addLineToDatabase(line);
            }
        } finally {
            reader.close();
        }
    }

    private void addLineToDatabase(String line) {
        storyArray.add(new Story (line));
    }


}