package com.insomnian.note.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.insomnian.note.Note;
import com.insomnian.note.actors.KeyVert;
import com.insomnian.note.actors.NoteVert;
import com.insomnian.note.enums.GameState;
import com.insomnian.note.game.Assets;
import com.insomnian.note.game.WorldController;
import com.insomnian.note.utils.Constants;
import com.insomnian.note.utils.GameManager;
import com.insomnian.note.utils.GamePreferences;

/**
 * Created by 1 on 29.03.2015.
 */
public class ScripLeftScreen extends AbstractGameScreen {

    private Image imgBackground;
    private Stage stage;
    public static NoteVert firstActor, secondActor;
    private Float currIndex, nextIndex;
    private Image znakImg;



    public ScripLeftScreen(Note game) {
        super(game);
    }

    private void buildStage() {
        this.imgBackground = new Image(this.game.gameSkin, "backgroundGame");
        imgBackground.setSize(stage.getViewport().getWorldWidth(), stage.getViewport().getWorldHeight());
        stage.addActor(this.imgBackground);
        znakImg = new Image(this.game.gameSkin, "ScripVertZnak");
        znakImg.setPosition(this.stage.getViewport().getWorldWidth() / 4,
                this.stage.getViewport().getWorldHeight() - znakImg.getHeight());
        stage.addActor(znakImg);

        stage.addActor(new KeyVert(game, 3, stage, 0));
        stage.addActor(new KeyVert(game, 4, stage, 1));
        stage.addActor(new KeyVert(game, 5, stage, 2));
        stage.addActor(new KeyVert(game, 6, stage, 3));
        stage.addActor(new KeyVert(game, 7, stage, 4));
        stage.addActor(new KeyVert(game, 1, stage, 5));
        stage.addActor(new KeyVert(game, 2, stage, 6));
        stage.addActor(new KeyVert(game, 3, stage, 7));
        stage.addActor(new KeyVert(game, 4, stage, 8));
        stage.addActor(new KeyVert(game, 5, stage, 9));
        stage.addActor(new KeyVert(game, 6, stage, 10));
        stage.addActor(new KeyVert(game,7,stage,11));
        stage.addActor(new KeyVert(game,1,stage,12));
        stage.addActor(new KeyVert(game,2,stage,13));
        stage.addActor(new KeyVert(game,3,stage,14));
        stage.addActor(new KeyVert(game,4,stage,15));
        stage.addActor(new KeyVert(game,5,stage,16));
        stage.addActor(new KeyVert(game,6,stage,17));
        stage.addActor(new KeyVert(game,7,stage,18));
        stage.addActor(new KeyVert(game,1,stage,19));
        stage.addActor(new KeyVert(game,2,stage,20));
        stage.addActor(new KeyVert(game,3,stage,21));
        stage.addActor(new KeyVert(game,4,stage,22));


//            stage.addActor( a = new DoKey(game,stage,2));
//            a = new DoKey(game,stage,3);
//            a.setTouchable(Touchable.enabled);
    }

    private void Back() {
        this.game.setScreen(new ScripMenuScreen(this.game));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        controller();////////////////////////

        stage.act(delta);
        stage.draw();
        renderGuiFpsCounter();
    }

    public void controller() {
        if (firstActor == null) {
            firstActor = new NoteVert(game,stage);
            currIndex = firstActor.getIndex();
            WorldController.KEYNUMBER = currIndex;
            stage.addActor(firstActor);
        }
        System.out.println(WorldController.KEYNUMBER);
        if (firstActor.getPosition().y <= stage.getViewport().getWorldHeight() / 2 ){
            if (secondActor == null) {
                secondActor = new NoteVert(game, stage);
                nextIndex = secondActor.getIndex();
                stage.addActor(secondActor);
                currIndex = nextIndex;
            }
        }
        if (firstActor.getNoteCliked(true)){
            firstActor.speedUp();
        }
        if (firstActor.getPosition().y <= this.stage.getViewport().getWorldHeight()/3.2 - 7) {

            GameManager.ourInstance.setGameState(GameState.WAITKEYPRESS);
            if (firstActor.getNoteCliked(true)) {
                currIndex = nextIndex;
                WorldController.KEYNUMBER = currIndex;
                firstActor.remove();
                firstActor = null;
                firstActor = secondActor;
                secondActor = null;
//                firstActor.move(true);
                GameManager.ourInstance.setGameState(GameState.MOVE);
            } else {
                GameManager.ourInstance.setGameState(GameState.WAITKEYPRESS);
            }
        }
    }

    @Override
    public void show() {
        Gdx.input.setCatchBackKey(true);
        this.stage = new Stage(new ExtendViewport(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT,game.camera)) {
            @Override
            public boolean keyUp(int keycode) {
                if ((keycode == Input.Keys.BACK) || (keycode == Input.Keys.ESCAPE)) {
                    if (GamePreferences.instance.isMusicEnabled()){
                        Assets.instance.music.menuMusic.play();
                    }
                    ScripLeftScreen.this.Back();
                }
                return false;
            }
        };
        firstActor = null;
        Gdx.input.setInputProcessor(stage);
        this.buildStage();
        this.stage.act();
        this.stage.draw();
        Assets.instance.music.menuMusic.stop();

    }

    @Override
    public void resize(int n, int n2) {
        this.stage.getViewport().update(n, n2, true);
    }

    @Override
    public void pause() {

    }


    @Override
    public void resume() {
//            this.game.camera.viewportWidth = Gdx.graphics.getWidth();
//            this.game.camera.viewportHeight = Gdx.graphics.getHeight();
    }

    @Override
    public void hide() {
//        this.stage.dispose();
    }

    @Override
    public void dispose() {
//            Assets.instance.dispose();
        this.stage.dispose();
    }

    private void renderGuiFpsCounter() {
        float x = 400;
        float y = 240;
        int fps = Gdx.graphics.getFramesPerSecond();
        BitmapFont fpsFont = Assets.instance.fonts.defaultNormal;
        if (fps >= 45) {
            // 45 or more FPS show up in green
            fpsFont.setColor(0, 1, 0, 1);
        } else if (fps >= 30) {
            // 30 or more FPS show up in yellow
            fpsFont.setColor(1, 1, 0, 1);
        } else {
            // less than 30 FPS show up in red
            fpsFont.setColor(1, 0, 0, 1);
        }
        stage.getBatch().begin();
        fpsFont.draw(stage.getBatch(), "FPS: " + fps, x, y);
        stage.getBatch().end();
        fpsFont.setColor(1, 1, 1, 1); // black
    }
}
