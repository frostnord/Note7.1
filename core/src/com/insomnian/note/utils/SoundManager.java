package com.insomnian.note.utils;


import com.badlogic.gdx.assets.AssetManager;
import com.insomnian.note.game.Assets;
import com.insomnian.note.game.WorldController;

/**
 * Created by 1 on 28.03.2017.
 */
public class SoundManager { //not used
//        public static String note;
//    public SoundManager(String note) {
//        this.note = note;
//    }
    public static void soundPlay(int note){
        if (GamePreferences.instance.isSoundEnabled()){
//            if (WorldController.GAMEMODE.equals("scrip")){
                String gameMoode = WorldController.GAMEMODE;
                String noteName = "sound/"+gameMoode+"/"+note+".wav";
//                Assets.instance.assetManager.get("sound/"+gameMoode+"/"+note);
//                Assets.getSound(noteName).play();
//            Assets.getSound()
//            }
        }
    }
}
