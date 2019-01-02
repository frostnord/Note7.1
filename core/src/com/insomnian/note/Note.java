package com.insomnian.note;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.insomnian.note.screens.DirectedGame;
import com.insomnian.note.screens.FirstMenuScreen;
import com.insomnian.note.screens.LoadingScreen;
import com.insomnian.note.screens.SplashScreen;

public class Note extends DirectedGame {

    public String densite;
//    public OrthographicCamera camera;
    public String typeScreen;

//    public AssetManager manager = new AssetManager();
//    public Skin gameSkin;
//    public Skin uiSkin;


//    { return this == UP ? DOWN : UP; }

    @Override
    public void create() {
//        getDensite();
        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.setScreen(new SplashScreen(this));
    }

    @Override
    public void dispose() {
        super.dispose();

    }

//    protected Preferences getPrefs()
//    {
//        if(preferences==null){
//            preferences = Gdx.app.getPreferences("ThrustCopter");
//        }
//        if(preferences==null){
//            System.out.println("null preferences");
//        }
//        return preferences;
//    }

    void getDensite() {
        if (Gdx.app.getType().toString() == "Android")
        {
            if (Gdx.graphics.getDensity() >= 4.0D)
            {
                this.densite = "xxxhdpi";
                return;
            }
            if (Gdx.graphics.getDensity() >= 3.0D)
            {
                this.densite = "xxhdpi";
                return;
            }
            if (Gdx.graphics.getDensity() >= 2.0D)
            {
                this.densite = "xhdpi";
                return;
            }
            if (Gdx.graphics.getDensity() >= 1.5D)
            {
                this.densite = "hdpi";
                return;
            }
            if (Gdx.graphics.getDensity() >= 1.0D)
            {
                this.densite = "mdpi";
                return;
            }
            this.densite = "ldpi";
            return;
        }
        this.densite = "hdpi";
    }


}
