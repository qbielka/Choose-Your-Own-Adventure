package com.qbielka.dinazeng.choose_your_own_adventure.databaseObjects;

public class Story {

    static int nextID = 1;

    int id;
    private String story;
    private int numButtons;

    private String button1Text;
    private int button1NextState;

    private String button2Text;
    private int button2NextState;

    private String button3Text;
    private int button3NextState;

    //private String button4Text;
    //private int button4NextState;

    public Story(String story){
        id = Integer.valueOf(story.charAt(0));

        story = story.substring(story.indexOf(',') + 1);
        this.story = story.substring(0, story.indexOf(','));
        story = story.substring(story.indexOf(',') + 1);

        numButtons = Integer.valueOf(story.charAt(0));
        story = story.substring(story.indexOf(',') + 1);

        button1Text = story.substring(0, story.indexOf(','));
        story = story.substring(story.indexOf(',') + 1);
        button2Text = story.substring(0, story.indexOf(','));
        story = story.substring(story.indexOf(',') + 1);
        button3Text = story.substring(0, story.indexOf(','));
        story = story.substring(story.indexOf(',') + 1);

        button1NextState = Integer.valueOf(story.charAt(0));
        button2NextState = Integer.valueOf(story.charAt(2));
        button3NextState = Integer.valueOf(story.charAt(4));
    }

    public String getStory (){
        return story;
    }

    public void setStory (String story){
        this.story = story;
    }

    public String getButton1(){
        return button1Text;
    }

    public int getValueButton1(){
        return button1NextState;
    }

    public String getButton2(){
        return button2Text;
    }

    public int getValueButton2(){
        return button2NextState;
    }

    public String getButton3(){
        return button3Text;
    }

    public int getValueButton3(){
        return button3NextState;
    }

    public void setButton1(String button1Text){
        this.button1Text = button1Text;
    }

    public void setValueButton1(int valueButton1){
        button1NextState = valueButton1;
    }

    public void setButton2(String button2Text){
        this.button2Text = button2Text;
    }

    public void setValueButton2(int valueButton2){
        button2NextState = valueButton2;
    }

    public void setButton3(String button3Text){
        this.button3Text = button3Text;
    }

    public void setValueButton3(int valueButton3){
        button3NextState = valueButton3;
    }

    private void setID(){
        id = nextID;
        nextID++;
    }
}
