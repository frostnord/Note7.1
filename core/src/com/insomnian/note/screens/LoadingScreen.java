package com.insomnian.note.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.insomnian.note.utils.Constants;

/**
 * Created by 1 on 20.10.2015.
 */
public class LoadingScreen extends AbstractGameScreen {

    private Stage stage;
    private Table layerBackground;
    private Image imgBackground;
    float timer = 1000.0f;

    public LoadingScreen(DirectedGame directedGame) {

        super(directedGame);
    }

    private void rebuildStage() {
        this.buildMenuLayers();
        this.assembleStage();
    }
    private void assembleStage() {
        this.stage.clear();
        Stack stack = new Stack();
        this.stage.addActor(stack);
        stack.setSize(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT);
        stack.add(this.layerBackground);
//        stack.add(this.layerSettings);
//        stack.add(this.layerKeyboard);
//        stack.add(this.layerLines);
//        stack.add(this.layerNote);
//        stack.add(this.layerControls);
    }
    private void buildMenuLayers() {
        this.layerBackground = this.buildBackgroundLayer();
    }
    private Table buildBackgroundLayer() {
        Table table = new Table();
        this.imgBackground = new Image(this.directedGame.gameSkin,"backgroundMenu");
        table.add(this.imgBackground).fill().expand();
        return table;
    }

    @Override
    public void hide() {
        this.stage.dispose();
    }

    @Override
    public void pause() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();



        if (this.directedGame.assetManager.update()&& this.timer < 0.0f) {
//            Assets.instance.init(this.directedGame.assetManager);
//            this.directedGame.setScreen(new FirstMenuScreen(directedGame));////////////////////////////
        }
        this.timer-=50f;
    }

    @Override
    public void resize(int n, int n2) {
        this.stage.getViewport().update(n, n2, false);
    }

    @Override
    public void show() {

        this.stage = new Stage(new ExtendViewport(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT));



//        this.directedGame.assetManager.load("sprites.atlas", TextureAtlas.class);
//        this.directedGame.assetManager.finishLoading();
//
//        this.directedGame.gameSkin = new Skin(Gdx.files.internal("sprites.json"), new TextureAtlas("sprites.atlas"));
//
//        Assets.instance.init(this.directedGame.assetManager);
        this.rebuildStage();
    }
}
