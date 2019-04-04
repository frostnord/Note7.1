package com.insomnian.note.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.insomnian.note.actors.PianoKeyVert;
import com.insomnian.note.actors.NoteVert;
import com.insomnian.note.enums.GameState;
import com.insomnian.note.game.Assets;
import com.insomnian.note.game.WorldController;
import com.insomnian.note.utils.Constants;
import com.insomnian.note.utils.GameManager;
import com.insomnian.note.utils.GamePreferences;

import java.util.ArrayList;

public class BassLeftScreen extends AbstractGameScreen {

    private Stage stage;
    private Image imgBackground;
    private Image znakImg;
    public static   NoteVert firstActor, secondActor;
    private Float currIndex, nextIndex;

    public BassLeftScreen(DirectedGame directedGame) {
        super(directedGame);
//        WorldController.firstActorClicked =false;//////////////кастыль

    }
    public static void firstActorSetNoteClicked(){
        firstActor .setNoteCliked();
    }

    @Override
    public void hide() {
        WorldController.worldReset();
        stage.dispose();

    }

    @Override
    public void pause() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        controller();////////////////////////

        stage.act(delta);
        stage.draw();
//        renderGuiFpsCounter();
    }

    @Override
    public void resize(int var1, int var2) {

    }

    @Override
    public void show() {
        Gdx.input.setCatchBackKey(true);
        stage = new Stage(new ExtendViewport(Constants.VIEWPORT_GUI_WIDTH,
                Constants.VIEWPORT_GUI_HEIGHT,directedGame.camera)) {
            @Override
            public boolean keyUp(int keycode) {
                if ((keycode == Input.Keys.BACK) || (keycode == Input.Keys.ESCAPE)) {
                    if (GamePreferences.instance.isMusicEnabled()){
                        Assets.instance.music.menuMusic.play();
                        stage.clear();
                    }
                    BassLeftScreen.this.directedGame.setScreen(new BassMenuScreen(directedGame));
                }
                return false;
            }
        };
        firstActor = null;/////////////////////////
        Gdx.input.setInputProcessor(stage);
        this.buildStage();
        this.stage.act();
        this.stage.draw();
        Assets.instance.music.menuMusic.stop();
    }

    private void buildStage() {
        this.imgBackground = new Image(this.directedGame.gameSkin, "backgroundGame");
        imgBackground.setSize(stage.getViewport().getWorldWidth(), stage.getViewport().getWorldHeight());
        stage.addActor(this.imgBackground);
        znakImg = new Image(this.directedGame.gameSkin, "BassVertZnak");
        znakImg.setPosition(this.stage.getViewport().getWorldWidth() / 4,
                this.stage.getViewport().getWorldHeight() - znakImg.getHeight());
        stage.addActor(znakImg);

        stage.addActor(new PianoKeyVert(directedGame,5, stage, 0));
        stage.addActor(new PianoKeyVert(directedGame,6, stage, 1));
        stage.addActor(new PianoKeyVert(directedGame,7, stage, 2));
        stage.addActor(new PianoKeyVert(directedGame,1, stage, 3));
        stage.addActor(new PianoKeyVert(directedGame,2, stage, 4));
        stage.addActor(new PianoKeyVert(directedGame,3, stage, 5));
        stage.addActor(new PianoKeyVert(directedGame,4, stage, 6));
        stage.addActor(new PianoKeyVert(directedGame,5, stage, 7));
        stage.addActor(new PianoKeyVert(directedGame,6, stage, 8));
        stage.addActor(new PianoKeyVert(directedGame,7, stage, 9));
        stage.addActor(new PianoKeyVert(directedGame,1, stage, 10));
        stage.addActor(new PianoKeyVert(directedGame,2,stage,11));
        stage.addActor(new PianoKeyVert(directedGame,3,stage,12));
        stage.addActor(new PianoKeyVert(directedGame,4,stage,13));//fa
        stage.addActor(new PianoKeyVert(directedGame,5,stage,14));
        stage.addActor(new PianoKeyVert(directedGame,6,stage,15));
        stage.addActor(new PianoKeyVert(directedGame,7,stage,16));
        stage.addActor(new PianoKeyVert(directedGame,1,stage,17));
        stage.addActor(new PianoKeyVert(directedGame,2,stage,18));
        stage.addActor(new PianoKeyVert(directedGame,3,stage,19));
        stage.addActor(new PianoKeyVert(directedGame,4,stage,20));
        stage.addActor(new PianoKeyVert(directedGame,5,stage,21));
        stage.addActor(new PianoKeyVert(directedGame,6,stage,22));
    }
    public void controller() {
        if (firstActor == null) {
            firstActor = new NoteVert(directedGame,stage);
            currIndex = firstActor.getIndex();
            WorldController.KEYNUMBER = currIndex;
            stage.addActor(firstActor);
        }
        if (firstActor.getPosition().y <= stage.getViewport().getWorldHeight() / 2 ){
            if (secondActor == null) {
                secondActor = new NoteVert(directedGame, stage);
                nextIndex = secondActor.getIndex();
                stage.addActor(secondActor);
                currIndex = nextIndex;
            }
        }
        if( WorldController.firstActorClicked){
//        if (firstActor.isNoteCliked()){
            firstActor.speedUp();
        }
        if (firstActor.getPosition().y <= this.stage.getViewport().getWorldHeight()/3.2 - 7) {

            GameManager.ourInstance.setGameState(GameState.WAITKEYPRESS);
            if(WorldController.firstActorClicked){
//            if (firstActor.isNoteCliked()) {
                WorldController.firstActorClicked =false;
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
}
