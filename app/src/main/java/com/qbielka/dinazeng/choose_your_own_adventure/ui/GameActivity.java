package com.qbielka.dinazeng.choose_your_own_adventure.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qbielka.dinazeng.choose_your_own_adventure.R;
import com.qbielka.dinazeng.choose_your_own_adventure.RecyclerViewAdapeters.StoryAdapter;
import com.qbielka.dinazeng.choose_your_own_adventure.model.Singleton;
import com.qbielka.dinazeng.choose_your_own_adventure.model.StoryModel;
import com.qbielka.dinazeng.choose_your_own_adventure.model.StoryPiece;

public class GameActivity extends AppCompatActivity {


    StoryModel storyModel;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerAdapter;
    RecyclerView.LayoutManager layoutManager;
//    Button button_1;
//    Button button_2;
//    Button button_3;
//    Button button_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        int key = Singleton.getInstance(this).gameState.getCurrentDatabaseStoryKey();
        storyModel = new StoryModel(key, this);



        recyclerView = findViewById(R.id.rvButton);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //setupButtons(storyPiece);

        StoryPiece storyPiece = storyModel.getNextStory();
        setStory (storyPiece);
    }

    public void setStory(StoryPiece storyPiece){
        TextView text = findViewById(R.id.game_story);
        text.setText(storyPiece.getStory());

        recyclerAdapter = new StoryAdapter(this, storyPiece.getButtons(), storyModel);
        recyclerView.setAdapter(recyclerAdapter);

    }
//todo remove these comments
//    public void setupButtons (StoryPiece storyPiece){
//        button_1 = findViewById(R.id.game_option1);
//        button_2 = findViewById(R.id.game_option2);
//        button_3 = findViewById(R.id.game_option3);
//        button_4 = findViewById(R.id.game_option4);
//
//        setVisibilities(storyPiece);
//        setButtonTexts(storyPiece);
//
//        setOnClickListeners(button_1, 1);
//        setOnClickListeners(button_2, 2);
//        setOnClickListeners(button_3, 3);
//        setOnClickListeners(button_4, 4);
//
//    }
//
//    /**
//     * Sets the text of the buttons if the button exists
//     */
//    private void setButtonTexts(StoryPiece storyPiece) {
//
//        // each if statement is independent from each other
//        if(isButtonNValid(1, storyPiece)) {
//            button_1.setText(storyPiece.getButtons().get(0).getButtonText());
//        }
//        if(isButtonNValid(2, storyPiece)) {
//            button_2.setText(storyPiece.getButtons().get(1).getButtonText());
//        }
//        if(isButtonNValid(3, storyPiece)) {
//            button_3.setText(storyPiece.getButtons().get(2).getButtonText());
//        }
//        if(isButtonNValid(4, storyPiece)) {
//            button_4.setText(storyPiece.getButtons().get(3).getButtonText());
//        }
//    }
//
//
//    /**
//     *
//     * @param buttonNum is the number of the button to be checked
//     * @return returns a boolean with the validity of the button.
//     */
//    private boolean isButtonNValid(int buttonNum, StoryPiece storyPiece) {
//        // If the button does not exist it is invalid
//        if(!(storyPiece.getButtons().size() > buttonNum - 1)){
//            return false;
//        }
//        // get gameState change from the button that is being checked
//        GameState change = storyPiece.getButtons().get(buttonNum - 1).getButtonEffects();
//
//        // get gameState default from the Singleton
//        GameState origin = Singleton.getInstance(this).gameState;
//
//
//        return GameState.isActionValid(change, origin);
//    }
//
//    private void setVisibilities(StoryPiece storyPiece) {
//
//        button_1.setVisibility(View.GONE);
//        button_2.setVisibility(View.GONE);
//        button_3.setVisibility(View.GONE);
//        button_4.setVisibility(View.GONE);
//
//        ArrayList<com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects.Button> buttonList
//                = storyPiece.getButtons();
//        for (int num = 0; num < buttonList.size(); num++){
//            if (isButtonNValid(1, storyPiece)){
//                button_1.setVisibility(View.VISIBLE);
//            }
//            if (isButtonNValid(2, storyPiece)){
//                button_2.setVisibility(View.VISIBLE);
//            }
//            if (isButtonNValid(3, storyPiece)){
//                button_3.setVisibility(View.VISIBLE);
//            }
//            if (isButtonNValid(4, storyPiece)){
//                button_4.setVisibility(View.VISIBLE);
//            }
//        }
//    }
//
//    private void setOnClickListeners(Button button, final int i) {
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                storyModel.buttonNPushed(i,getApplicationContext());
//                updateUI();
//                Log.w("THING",Singleton.getInstance(getApplicationContext()).gameState.toString());
//                Log.w("THING",storyModel.getNextStory().getButtons().toString());
//            }
//        });
//    }
//
//    private void updateUI(){
//        StoryPiece storyPiece = storyModel.getNextStory();
//
//        setStory(storyPiece);
//        setVisibilities(storyPiece);
//        setButtonTexts(storyPiece);
//
//    }
//
}