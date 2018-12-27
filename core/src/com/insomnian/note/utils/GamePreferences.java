package com.insomnian.note.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class GamePreferences {
    public static final String TAG = GamePreferences.class.getName();
    public static final GamePreferences instance = new GamePreferences();
    private Preferences prefs = Gdx.app.getPreferences("notanot.prefs");
    public boolean sound;

    private GamePreferences() {
        this.load();
    }
    public boolean languageRu(){
        return prefs.getBoolean("languageRu",true);
    }
    public void setLanguage (boolean langChange){
        prefs.putBoolean("languageRu",langChange);
        prefs.flush();
    }
    public boolean isSoundEnabled() {
        return prefs.getBoolean("sound.enabled", true);
    }
    public void setSoundEnabled(boolean soundEffectsEnabled) {
        prefs.putBoolean("sound.enabled", soundEffectsEnabled);
        prefs.flush();
    }
    public boolean isMusicEnabled() {
        return prefs.getBoolean("music.enabled", true);
    }

    public void setMusicEnabled(boolean musicEnabled) {
        prefs.putBoolean("music.enabled", musicEnabled);
        prefs.flush();
    }
    public void flush (){
        prefs.flush();
    }

    public void load() {
        this.sound = this.prefs.getBoolean("sound", true);
    }
    public int loadLastLevel() {
        if (this.prefs.getInteger("nextLevel-" + this.loadActualPack()) != 0) {
            return this.prefs.getInteger("nextLevel-" + this.loadActualPack());
        }
        return 0;
    }
    public int loadActualPack() {
        if (this.prefs.getInteger("actualPack") != 0) {
            return -1 + this.prefs.getInteger("actualPack");
        }
        return 0;
    }
    public int getNumberOfStar(int mode, int pack) {
        return this.prefs.getInteger("levelStar-" + mode + "-" + pack);
    }
    public void saveLastLevelStar(int mode, int pack,int star) {
//        int n3 = this.loadActualPack();
//        if (n2 != 0 && (this.prefs.getInteger("levelStar-" + n3 + "-" + n) < n2 || this.prefs.getInteger("levelStar-" + n3 + "-" + n) == 0)) {
            this.prefs.putInteger("levelStar-" + mode + "-" + pack, star);
//            this.setNextLevel(n);
        //game mode - 1 scrip
            // 2 - bass
//        }
        this.prefs.flush();
    }
}
