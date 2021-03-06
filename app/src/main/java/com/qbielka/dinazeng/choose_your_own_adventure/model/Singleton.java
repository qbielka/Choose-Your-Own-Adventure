package com.qbielka.dinazeng.choose_your_own_adventure.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.Gson;

public class Singleton {
    // final variables are keys to access SharedPreferences
    private static final String GAME_STATE_CODE = "GameState";
    private static final String SHARED_PREFERENCES_ACCESS = "ChooseYourOwnAdventureAccess";

    // suppresses the memory Leak issue because this is a singleton
    @SuppressLint("StaticFieldLeak")
    private static Singleton instance = null;

    // private variables to access a json serializer library and the main app's context
    private static final Gson gson = new Gson();

    //public member data
    public GameState gameState;

    private Singleton(Context appContext){

        // load in last save data
        SharedPreferences savedGame = appContext.getSharedPreferences(SHARED_PREFERENCES_ACCESS, Context.MODE_PRIVATE);
        String saveFile = savedGame.getString(GAME_STATE_CODE, "");

        // turn save data into a current game or start a new game if no save data exists
        if(saveFile.isEmpty()){
            gameState = new GameState();
        }else {
            gameState = gson.fromJson(saveFile, GameState.class);
        }

    }

    public static void saveGame(Context appContext){
        // get save data from the current game
        String saveFile = gson.toJson(getInstance(appContext).gameState);

        // make a saveFile in sharedPreferences
        SharedPreferences savedGame = appContext.getSharedPreferences(SHARED_PREFERENCES_ACCESS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = savedGame.edit();
        editor.putString(GAME_STATE_CODE, saveFile);
        editor.apply();
    }

    // the getInstance method that allows other piece of the code to see this
    public static Singleton getInstance(Context context){
        if(instance == null){
            instance = new Singleton(context);
        }

        return instance;
    }

}
