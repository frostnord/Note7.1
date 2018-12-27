package com.insomnian.note.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.insomnian.note.Note;
import com.insomnian.note.actors.KeyGoriz;
import com.insomnian.note.actors.KeyVert;
import com.insomnian.note.actors.Lines;
import com.insomnian.note.actors.NoteGoriz;
import com.insomnian.note.game.Assets;
import com.insomnian.note.utils.Constants;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.insomnian.note.utils.GamePreferences;

public class ScripMiddleScreen extends AbstractGameScreen {

    java.util.Stack st;
    private Stage stage;
//    private Table layerBackground;
    private Image imgBackground;
    private Button keybordImg;
    private Table layerKeyboard;
    private float keybordHeight;
//    private KeyStatus keyStatus;
    private Image lineImg , leftBorder , rightBorder;
    private Table layerLines;
    private Image znakImg;
    private Table layerZnak;
    private static Array<NoteGoriz> actors;
    private float key;
    private Float time = 300f;
    private TextureAtlas.AtlasRegion pressedKey;
    boolean rightButton = false;
    public static int scoreRight = 0;
    public static int scoreWrong = 0;
    private Animation  animation;
    private TextureRegion lineTextureRegion;
    private float widthW ;
    private float hidthH ;
    private TextureRegion triangleTextureRegion;
    private Sprite sp;

    public static int index;

    public ScripMiddleScreen(Note game) {
        super(game);
    }

    private void buildStage() {
        this.imgBackground = new Image(this.game.gameSkin, "backgroundGame");
        imgBackground.setSize(stage.getViewport().getWorldWidth(), stage.getViewport().getWorldHeight());
        stage.addActor(this.imgBackground);
        znakImg = new Image(this.game.gameSkin, "ScripGorZnak");
        znakImg.setPosition(0, this.stage.getViewport().getWorldHeight() / 2.7f);
        stage.addActor(znakImg);

        leftBorder = new Image(Assets.instance.decoration.leftBorder);
        leftBorder.setSize(this.stage.getViewport().getWorldWidth() / 90, this.stage.getViewport().getWorldHeight() / 4f);
        leftBorder.setPosition(this.stage.getViewport().getWorldWidth() / 23f * 8f - (this.stage.getViewport().getWorldWidth() / 90 - 1), 0);
        stage.addActor(leftBorder);

        rightBorder = new Image(Assets.instance.decoration.rightBorder);
        rightBorder.setSize(this.stage.getViewport().getWorldWidth() / 90, this.stage.getViewport().getWorldHeight() / 4f);
        rightBorder.setPosition(this.stage.getViewport().getWorldWidth() / 23f * 15f, 0);
        stage.addActor(rightBorder);

        stage.addActor(new KeyGoriz(game, 1, stage, 8));
        stage.addActor(new KeyGoriz(game, 2, stage, 9));
        stage.addActor(new KeyGoriz(game, 3, stage, 10));
        stage.addActor(new KeyGoriz(game, 4, stage, 11));
        stage.addActor(new KeyGoriz(game, 5, stage, 12));
        stage.addActor(new KeyGoriz(game, 6, stage, 13));
        stage.addActor(new KeyGoriz(game, 7, stage, 14));

        stage.addActor(new Lines(game,stage));

    }
    //    private void buildMenuLayers() {
//        this.layerBackground = this.buildBackgroundLayer();
//        this.layerKeyboard = this.buildKeyboardLayer();
//        this.layerZnak = this.buildZnakLayer();
//        this.layerLines = this.buildLinesLayer();
//    }
//    private Table buildZnakLayer() {
//        Table table = new Table();
//        table.left().top().padLeft(50).padTop(90);
//        znakImg = new Image(this.game.gameSkin, "ScripGorZnak");
//        table.add(znakImg);
//        return table;
//        float lineW = widthW / 100 ;
//        float lineH = (hidthH - (hidthH / 4f)) / 23;
//        Table table = new Table();
//        table.setSize(stage.getViewport().getWorldWidth(), stage.getViewport().getWorldHeight());
//        table.bottom().left().padBottom(stage.getViewport().getWorldHeight() / 4f);
//        stage.getBatch().begin();
//        for (int i = 1; i < 23 ; i++) {
//            stage.getBatch().draw(triangleTextureRegion, widthW - lineW, (lineH * i) + (hidthH / 4f)- lineH / 2 + 2, widthW / 100, (hidthH - (hidthH / 4f)) / 23);
//            i++;
//        }
//        stage.getBatch().draw(lineTextureRegion, widthW / 23, (lineH * 7) + (hidthH / 4f), widthW, hidthH / 200);
//        stage.getBatch().draw(lineTextureRegion, widthW / 23, (lineH * 9) + (hidthH / 4f), widthW, hidthH / 200);
//        stage.getBatch().draw(lineTextureRegion, widthW / 23, (lineH * 11) + (hidthH / 4f), widthW, hidthH / 200);
//        stage.getBatch().draw(lineTextureRegion, widthW / 23, (lineH * 13) + (hidthH / 4f), widthW, hidthH / 200);
//        stage.getBatch().draw(lineTextureRegion, widthW / 23, (lineH * 15) + (hidthH / 4f), widthW, hidthH / 200);
//        lineImg = new Image(Assets.instance.decoration.lineImg);
//        table.add(lineImg).setActorBounds(widthW / 23, (lineH * 7) + (hidthH / 4f), widthW, hidthH / 200);
//        stage.addActor(table);
////        return table;
//    private Table buildKeyboardLayer() {
//        final Table table = new Table();
//        table.center().bottom();
//        this.keybordImg = new Button(this.game.gameSkin, "keybord2");
//        table.add(this.keybordImg);
//        keybordHeight = keybordImg.getTop();
//        this.keybordImg.addListener(new ClickListener() {
//            @Override
//            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
////                Gdx.input.vibrate(20);
//                keyStatus = KeyStatus.DOWN;
//                keyPressed(x);
//
//                return true;
//            }
//
//            @Override
//            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
////                game.setScreen(new LevelScreen(game));
////                dispose();
//                keyStatus = KeyStatus.UP;
//                rightButton = false;
//            }
//        });
//        return table;
//    public enum KeyStatus {
//        DOWN,
//        UP;
//    }
//    private Table buildBackgroundLayer() {
//        Table table = new Table();
//        this.imgBackground = new Image(this.game.gameSkin, "backgroundGame");
//        table.add(this.imgBackground);
//        return table;
//    public static void setScoreRight() {
//        scoreRight++;
//    public static void setScoreWrong() {
//        scoreWrong++;
//    public void drawKey(float key) {
////        float keyPosition = 8 + (34 * (int) key);
//        float keyPosition = keybordImg.getX() + 4 +(34 * (int)key) ;
//
//        if (((int) key == 0) || ((int) key == 3) ) {
//            pressedKey = Assets.instance.noteImg.doKeyImg;
//        } else if ((int) key == 4) {
//            pressedKey = Assets.instance.noteImg.solKeyImg;
//        } else if ((int) key == 5) {
//            pressedKey = Assets.instance.noteImg.laKeyImg;
//        } else if ((int) key == 6)  {
//            pressedKey = Assets.instance.noteImg.siKeyImg;
//        } else if ((int) key == 1)  {
//            pressedKey = Assets.instance.noteImg.reKeyImg;
//        } else if ((int) key == 2) {
//            pressedKey = Assets.instance.noteImg.miKeyImg;
//        }
//        if (rightButton) {
//            stage.getBatch().setColor(0.0f, 1.0f, 0.0f, 1.0f);
//        }else{
//            stage.getBatch().setColor(1.0f, 0.0f, 0.0f, 1.0f);
//
//        }
//
//        stage.getBatch().begin();
//        stage.getBatch().draw(pressedKey, keyPosition, 1, pressedKey.getRegionWidth(), pressedKey.getRegionHeight());
////        stage.getBatch().setColor(1, 1, 1, 1);
//        stage.getBatch().end();
////        System.out.println(keyPosition);
//
    @Override
    public void resize(int n, int n2) {
        this.stage.getViewport().update(n, n2, true);
    }

    public static Array<NoteGoriz> getNoteActors(){
        return actors;
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
    private void Back() {
        this.game.setScreen(new ScripMenuScreen(this.game));
    }
//    }
    //    private void assembleStage() {
//        this.stage.clear();
//        com.badlogic.gdx.scenes.scene2d.ui.Stack stack = new Stack();
//        this.stage.addActor(stack);
//
//        stack.setSize(800.0f, 480.0f);
////        stack.add(this.layerBackground);
//
//        stack.add(this.layerLines);
//        stack.add(layerZnak);
////        stack.add(this.layerKeyboard);
//
//    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        stage.act(delta);
//        buildLinesLayer();
        controller();

//        if (keyStatus == KeyStatus.DOWN) {
//            drawKey(key);
//        }
        renderGuiFpsCounter();
        score();

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

    private  void score (){
//        int fps = Gdx.graphics.getFramesPerSecond();
        BitmapFont score = Assets.instance.fonts.levelCompleted;

        float x = rightBorder.getX()+ 50;
        float y = rightBorder.getHeight();

        score.setColor(1, 0, 0, 1);
        stage.getBatch().begin();
        score.draw(stage.getBatch(), " " + scoreWrong, x, y - score.getCapHeight()- 10 );
        score.setColor(0, 1, 0, 1);
        score.draw(stage.getBatch(), " " + scoreRight, x , y );
        stage.getBatch().end();
    }

//    }

//    }

//    private void keyPressed(float x) {
//
//
//        key = (x - 3) / 34;
////        System.out.println(key);
////        System.out.println( actors.get(0).getNoteNumber());
//
//        if (actors.size != 0 ) {
//            if (actors.get(0).getNoteNumber() == (int) key) {
//                actors.get(0).setNoteCliked(true);
//                rightButton = true;
////            System.out.println(actors.get(0).getName());
//                actors.removeIndex(0);
//                scoreRight +=1;
//            }else {
//                actors.get(0).setNoteCliked(true);
////                actors.get(0).setNoteCliked(true);
//                actors.removeIndex(0);
//                scoreWrong +=1;
//            }
//        }
//    }
    public void controller() {
        time += 1;
        if (time >= 220f) {
            NoteGoriz noteGoriz = new NoteGoriz(game,stage,stage.getViewport().getWorldHeight(),
                    stage.getViewport().getWorldHeight()-this.stage.getViewport().getWorldHeight() / 4f);

            actors.add(noteGoriz);
            stage.addActor(noteGoriz);
            time = 0f;
//            index = noteGoriz.getIndex();
//            System.out.println(actors.get(0).getNoteKey());/
//            if (actors.size >=4 ){
//                System.out.println(actors.get(0).getNoteKey() + " " +  actors.get(1).getNoteKey()+ " " +  actors.get(2).getNoteKey()+ " " +  actors.get(3).getNoteKey());
//            }
        }

        if (actors.size != 0 ) {
            if (actors.get(0).getPosition().x <= 250) {
                if (!actors.get(0).getNoteClicked()) {
                    actors.get(0).setNoteCliked(true);
                    actors.removeIndex(0);
                    scoreWrong += 1;
                }
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
                    ScripMiddleScreen.this.Back();
                }
                return false;
            }
        };
        Gdx.input.setInputProcessor(stage);


        this.buildStage();
        actors = new Array();
//        NoteGoriz noteGoriz = new NoteGoriz(game,stage,stage.getViewport().getWorldHeight(),
//                stage.getViewport().getWorldHeight()-this.stage.getViewport().getWorldHeight() / 4f);
//        actors.add(noteGoriz);
//        stage.addActor(noteGoriz);
//        index = noteGoriz.getIndex();


//        controller();  //включить если заглючит
//        this.stage.act(); //включить если заглючит
//        this.stage.draw(); //включить если заглючит
    }

//    }
}
