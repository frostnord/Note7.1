package com.insomnian.note.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.insomnian.note.actors.BlackNote;
import com.insomnian.note.enums.GameState;

import static com.insomnian.note.screens.BassLeftScreen.firstActor;

/**
 * Created by 1 on 13.04.2015.
 */
public class DirectedGame extends Game {

    public AssetManager assetManager = new AssetManager();
    public Skin gameSkin;
    public Skin uiSkin;
    public String gameStatus = "action";
    public GameState gameState = GameState.MOVE ;
    public OrthographicCamera camera;


    @Override
    public void create() {

//        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());


    }
}
