package com.insomnian.note.utils;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;

public class Constants {
//    800 480

    // Visible directedGame world is 5 meters wide
    public static final float VIEWPORT_WIDTH = 5.0f;
    // Visible directedGame world is 5 meters tall
    public static final float VIEWPORT_HEIGHT = 5.0f;

    public static final float VIEWPORT_GUI_WIDTH = 1920.0f;
    public static final float VIEWPORT_GUI_HEIGHT = 1080.0f;
    public static float MENU_BUTTON_SIZE = 0.0f;
    public static float ASPECT_RATIO = 0.0f;






    public static final int APP_WIDTH = Gdx.graphics.getWidth();
    public static final int APP_HEIGHT = Gdx.graphics.getHeight();


    public static final String SCRIP_BUTTON_REGION_NAME = "ScripButton";//////  ScripKey
    public static final String BASS_BUTTON_REGION_NAME = "BassButton";//BassKey
    public static final String SETTINGS_REGION_NAME = "SetingsButton";


    public static final String TRENING_SCRIP_LEFT_REGION_NAME = "TreningScrip_left";
    public static final String LEARNING_SCRIP_MID_REGION_NAME = "LearningScrip_mid";
    public static final String PRACTICE_SCRIP_RIGHT_REGION_NAME = "PracticeScrip_right";




    public static final String TRENING_BASS_LEFT_REGION_NAME = "TreningBass_left";


    public static final String LEARNING_BASS_RIGHT_REGION_NAME = "LerningBass_right";


    public static final String PRACTICE_BASS_MIDDLE_REGION_NAME = "PracticeBass_middle";



    public static final String SPRITES_ATLAS_PATH = "sprites.atlas";
    public static final String NOTE_REGION_NAME = "note";
    public static final String SPRITES_PATH = "1.png";
    public static final String BACKGROUND_IMAGE_PATH = "background.png";
    public static final String VERTLINES_IMAGE_PATH = "vertlines.png";
    public static final String KEYBORD_IMAGE_PATH = "keybord.png";

    public static final String SOUND_ON_REGION_NAME = "sound_on";
    public static final String SOUND_OFF_REGION_NAME = "sound_off";

    static {
//        VIEWPORT_GUI_WIDTH = Gdx.graphics.getWidth();
//        VIEWPORT_GUI_HEIGHT = Gdx.graphics.getHeight();
//        MENU_BUTTON_SIZE = VIEWPORT_GUI_HEIGHT / 8.0f;
        ASPECT_RATIO =  VIEWPORT_GUI_WIDTH / VIEWPORT_GUI_HEIGHT ;

    }
}
