package com.insomnian.note.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.insomnian.note.Note;
import com.insomnian.note.actors.KeyGorizPack;
import com.insomnian.note.actors.Lines;
import com.insomnian.note.actors.BlackNote;
import com.insomnian.note.game.Assets;
import com.insomnian.note.utils.Levels;
import com.insomnian.note.utils.Constants;

/**
 * Created by 1 on 13.02.2016.
 */
public class MusicScreen implements Screen {
    private int number;
    private Note game;
    private ScrollPane scroller;
    private Stage stage;
    private Table layerBackground;
    private Array<BlackNote> actors1 = new Array<BlackNote>();
    private int[] ar;
    private Image znakImg;
    private float time = 300;
    private int a = 0;
    private int b = 0;
    private TextureRegion lineImg;
    private int time2 = 0;


    public MusicScreen(final Note game, int number) {
//        super(directedGame);
        this.game = game;
        lineImg= Assets.instance.decoration.lineImg;
//        this.number = number;
        ar = Levels.getLevel(number);
//        this.whate = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "MusicScr");
        Gdx.input.setCatchBackKey(true);
        this.stage = new Stage(new ExtendViewport(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT, game.camera)) {
            @Override
            public boolean keyUp(int keycode) {

                if ((keycode == Input.Keys.BACK) || (keycode == Input.Keys.ESCAPE)) {
                    MusicScreen.this.Back();
                }
                return false;
            }
        };
        Gdx.input.setInputProcessor(stage);
//        mode = 1;

//        GameManager.ourInstance.setGameState(GameState.MOVE);/////////////////////////

//        this.atlas = (TextureAtlas)this.directedGame.assetManager.get("sprites.atlas", TextureAtlas.class);


        this.buildStage();
    }

    private void controller() {
        if(b == 4 ){
            time2 +=1;
            if (time2 == 600){ //time bethvin
                b = 0;
            }
        }


        time += 1;
        if (time >= 220f && a != ar.length && b != 4) {
//            System.out.println(ar[a] + "dsds");
            BlackNote blackNote1 = new BlackNote(game, ar[a], stage, stage.getViewport().getWorldHeight(),
                    stage.getViewport().getWorldHeight() - this.stage.getViewport().getWorldHeight() / 4f,actors1);
            stage.addActor(blackNote1);
            actors1.add(blackNote1);
            a++;
            time = 0f;
            b++;
        }
    }

    private void onLevelSelectClicked(int n) {
        System.out.println(n);
//        if (n == actors1.get(0).getNumber()) {

//        }
    }
//        this.directedGame.levelToLoad = n;
//        ScripPackScreen.this.directedGame.setScreen(new ScripPracticeScreen(directedGame, n));
//        AudioManager.instance.play(com.gamelounge.chrooma.directedGame.Assets.instance.sounds.buttonSound, 1.0f);


    private void buildStage() {
        this.layerBackground = this.buildBackgroundLayer();
        stage.addActor(layerBackground);
        stage.addActor(new Lines(game, stage));
//        this.layerKeyboard=this.buildKeyboardLayer();
//        this.layerLines = this.buildLinesLayer();
//        this.layerControls = this.buildControlsLayer();
//        this.layerSettings = this.buildSettingsLayer();
    }

    private Table buildBackgroundLayer() {
        Table table = new Table();
        table.setBackground(game.gameSkin.getDrawable("backgroundGame"));
//        table.debug();
        table.setSize(stage.getViewport().getWorldWidth(), stage.getViewport().getWorldHeight());
        table.setPosition(0.0f, 0.0f);
        znakImg = new Image(this.game.gameSkin, "ScripGorZnak");
        znakImg.setPosition(0, this.stage.getViewport().getWorldHeight() / 2.7f);
        table.addActor(znakImg);

        KeyGorizPack keyGorizPack;
        for (int i = 8; i < 15; i++) {
            keyGorizPack = new KeyGorizPack(game, i - 7, stage, i);
            final int finalI = i;
            keyGorizPack.addListener(new ClickListener() {
                //            @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                    ScripPracticeScreen.this.onLevelSelectClicked(finalI);
                    KeyGorizPack key = (KeyGorizPack) event.getListenerActor();

                    if (actors1.size != 0) {
                        System.out.println(key.getKey()+" key");
                        System.out.println(actors1.get(0).getKey()+" number");

                        if (key.getKey() == actors1.get(0).getKey()) {
                            key.status = 2;//green
//                        System.out.println("r");
                        } else {
                            key.status = 3;//red
                            actors1.get(0).showTitle=true;
//                        System.out.println("w");
                        }
                        actors1.get(0).isNoteBlack =false;
                        actors1.removeIndex(0);
                    } else {
                        key.status = 3;
                    }
                    return true;
                }

                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    KeyGorizPack key = (KeyGorizPack) event.getListenerActor();
                    key.status = 1;
                }
            });
            table.addActor(keyGorizPack);
        }
        return table;
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
        renderGuiFpsCounter();
        controller();
    }

    private void Back() {
        this.game.setScreen(new ScripPackScreen(this.game));
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
        fpsFont.setColor(1, 1, 1, 1); // whate
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

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        this.stage.dispose();
    }
}
