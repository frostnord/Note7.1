package com.insomnian.note.game;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.utils.Array;
import com.insomnian.note.actors.NoteGoriz;
import com.insomnian.note.enums.GameMode;

/**
 * Created by 1 on 08.05.2015.
 */
public class WorldController  {

    public static Float KEYNUMBER = 23f ;
    private static String GAMEMODE ;
    private static GameMode gameMode;
    public static boolean firstActorClicked = false;
    public static Array<NoteGoriz> actors = new Array<NoteGoriz>();
    public static int scoreRight = 0;
    public static int scoreWrong = 0;
//    public WorldController() {
//        actors = new Array();
//    }

    public static Array<NoteGoriz> getNoteActors(){
        return actors;
    }

    public static void worldReset(){
        firstActorClicked =false;
        scoreRight = 0;
        scoreWrong = 0;
    }



    public static void setGameModeScrip(){
        gameMode = GameMode.SCRIP;
        GAMEMODE = "scrip";
    }
    public static void setGameModeBass(){
        gameMode = GameMode.BASS;
        GAMEMODE = "bass";
    }
    public static GameMode getGameMode(){
        return gameMode;
    }
    public static String getMusicPath(){
        return GAMEMODE;
    }
}
