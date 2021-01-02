package com.qbielka.dinazeng.choose_your_own_adventure.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import com.qbielka.dinazeng.choose_your_own_adventure.R;
import com.qbielka.dinazeng.choose_your_own_adventure.database.StoryDatabaseHelper;
import com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects.Story;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LauncherActivity extends AppCompatActivity {

    StoryDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

        db = new StoryDatabaseHelper(this);
        boolean firstTimeRunning = true;
        //todo reset firstTimeRunning to whatever we stored in sharedPreferences
        try {
            if(firstTimeRunning){
                readCSVFileIntoDatabase();
            }
            startActivity(intent);
        } catch (IOException e){
            // todo????
            // I have no solution for what happens right now the app essentially needs to crash
        }
    }

    private void readCSVFileIntoDatabase() throws IOException {
        final Resources resources =  getResources();
        InputStream inputStream = resources.openRawResource(R.raw.story_input);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                addLineToDatabase(line);
            }
        }
    }

    private void addLineToDatabase(String line) {
        if(line == null || line.length() < 2){
            return;
        }
        db.insert(new Story(line));
    }


}