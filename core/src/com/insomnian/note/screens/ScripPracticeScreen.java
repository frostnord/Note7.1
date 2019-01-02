package com.insomnian.note.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.insomnian.note.actors.KeyGorizPack;
import com.insomnian.note.actors.Lines;
import com.insomnian.note.actors.BlackNote;
import com.insomnian.note.menu.PauseWindow;
import com.insomnian.note.menu.WinWindow;
import com.insomnian.note.enums.GameState;
import com.insomnian.note.game.Assets;
import com.insomnian.note.utils.Constants;
import com.insomnian.note.utils.GamePreferences;
import com.insomnian.note.utils.LevelRandomizer;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;


public class ScripPracticeScreen extends AbstractGameScreen {

    //    private final Color black;
    private int number;
    private DirectedGame directrgame;
    private ScrollPane scroller;
    private Stage stage;
    private Table layerBackground;
    private Array<BlackNote> actors1 = new Array<BlackNote>();
    private Image znakImg;
    private float time = 300;
    private int a = 0;
    private int noteInArray = 0;
    private int massiv = 20;
    private int time2 = 0;
    private LevelRandomizer randomizer = new LevelRandomizer();
    private int score = 0 ;
    private Table scoreLayer;
    private Label scoreLabel;
    private Label.LabelStyle labelStyle;
    private TextButton btnMenuScrip;
    String noteText = "?";
    private boolean showNote = false;
    private Image leftBorder;
    private Image rightBorder;
    private Dialog dialog;
    private Window window;
//    private String status = "action";
    private int star = 0;////


    public ScripPracticeScreen(DirectedGame directedGame, int number) {
        super(directedGame);
        this.directrgame = directedGame;
        this.number = number;
//        directedGame.gameStatus = "action";
        directedGame.gs = GameState.MOVE;
        if (GamePreferences.instance.isMusicEnabled()) {
            Assets.instance.music.menuMusic.stop();
        }
//        Gdx.app.log("GameScreen", "Starting level: " + number);
    }

    private void controller() {
            scoreLabel.setText("" + score);
            if (massiv != 0) {
                if (noteInArray == 4) {
                    time2 += 1;
                    if (time2 == 500) { //time between
                        noteInArray = 0;
                        time2 = 0;
                    }
                }
                time += 1;
                if (time >= 220f && massiv != 0 && noteInArray != 4) {
                    int s = randomizer.getRandom(number);
                    BlackNote blackNote1 = new BlackNote(directrgame, s, stage, stage.getViewport().getWorldHeight(),
                            stage.getViewport().getWorldHeight() - this.stage.getViewport().getWorldHeight() / 4f, actors1);
                    stage.addActor(blackNote1);
                    actors1.add(blackNote1);
                    massiv--;
                    time = 0f;
                    noteInArray++;
                }
            } else if (actors1.size == 0) {
//                initWindow();
                ////////вин виндов тут
                WinWindow winWindow =  new WinWindow("",directrgame.uiSkin,stage,score,directedGame,number,star);
                winWindow.setPosition(stage.getViewport().getWorldWidth() / 4, stage.getViewport().getWorldHeight() / 3);
                stage.addActor(winWindow);
//                status("pause");
                int currentStar = GamePreferences.instance.getNumberOfStar(1, number);
                if (currentStar < star) {
                    GamePreferences.instance.saveLastLevelStar(1, number, star);
                }
            }
    }

    private void onLevelSelectClicked(int n) {
        System.out.println(n);
//        if (n == actors1.get(0).getNumber()) {

//        }
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "ScripPracticeScr ");
        Gdx.input.setCatchBackKey(true);
        this.stage = new Stage(new ExtendViewport(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT, directrgame.camera)) {
            @Override
            public boolean keyUp(int keycode) {
                if ((keycode == Input.Keys.BACK) || (keycode == Input.Keys.ESCAPE)) {
                    if (directrgame.gs != GameState.PAUSE) {

                        directrgame.gs = GameState.PAUSE;
                        PauseWindow pauseWindow = new PauseWindow("", stage, score, directrgame, number);
                        stage.addActor(pauseWindow);
//                    ScripPracticeScreen.this.Back() ;
//                    status("pause");
//                    directedGame.gameStatus = "pause";
                    }else {
                        if (GamePreferences.instance.isMusicEnabled()) {
                            Assets.instance.music.menuMusic.play();
                        }
                        ScripPracticeScreen.this.Back() ;
                    }
                }
                return false;
            }
        };
        Gdx.input.setInputProcessor(stage);
//        mode = 1;
//        GameManager.ourInstance.setGameState(GameState.MOVE);/////////////////////////
        this.buildStage();
//        Window window = new Window("title",Assets.instance.window);
    }
//        this.directedGame.levelToLoad = n;
//        ScripPackScreen.this.directedGame.setScreen(new ScripPracticeScreen(directedGame, n));


    private void buildStage() {
        this.layerBackground = this.buildBackgroundLayer();
        this.scoreLayer = buildScoreLayer();
        stage.addActor(layerBackground);
        stage.addActor(scoreLayer);
        stage.addActor(new Lines(directrgame, stage));
//        this.layerKeyboard=this.buildKeyboardLayer();
//        this.layerLines = this.buildLinesLayer();
//        this.layerControls = this.buildControlsLayer();
//        this.layerSettings = this.buildSettingsLayer();

    }


    private Table buildScoreLayer() {
        Table table = new Table();
//        table.setSize(stage.getWidth(),stage.getHeight());
//        table.setPosition(0.0f, 0.0f);
//        table.setFillParent(true);
//        table.setDebug(true);

        table.setSize(stage.getViewport().getWorldWidth(), stage.getViewport().getWorldHeight());
//        table.right().bottom();
        labelStyle = new Label.LabelStyle(Assets.instance.fonts.packScreenScore, new Color(1.0f, 1.0f, 1.0f, 1.0f));
//        Label scoreLabel = new Label((String.format("%02d",score)),labelStyle );
        scoreLabel = new Label("" + score, labelStyle);
        table.add(scoreLabel).padLeft(150).padTop(25).left().top().expand();
        table.row();
//        table.add(scoreLabel).padRight(stage.getViewport().getWorldWidth() / 8).padBottom(stage.getViewport().getWorldHeight() / 8);
//        System.out.println(score);
//        scoreLabel.setAlignment(16);
//        table.add(scoreLabel).padRight(stage.getViewport().getWorldWidth() / 20).padBottom(stage.getViewport().getWorldHeight()/ 10);
        this.btnMenuScrip = new TextButton("?", Assets.instance.skin.textButtonStyle);
        this.btnMenuScrip.setOrigin(btnMenuScrip.getWidth() / 2.0f, btnMenuScrip.getHeight() / 2.0f);
//        table.add(this.btnMenuScrip).size(Constants.VIEWPORT_GUI_WIDTH /4f ,Constants.VIEWPORT_GUI_WIDTH /4f*  Constants.ASPECT_RATIO);/////////////////////////////
//        System.out.println(stage.getViewport().getWorldWidth() / 4);
        this.btnMenuScrip.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
//                FirstMenuScreen.this.onPlayClicked();/////////////////////
                showNote = true;
                showNote();
                WinWindow winWindow =  new WinWindow("",directrgame.uiSkin,stage,score,directedGame,number,star);
                winWindow.setPosition(stage.getViewport().getWorldWidth() / 4, stage.getViewport().getWorldHeight() / 3);
                stage.addActor(winWindow);
//                dialog.show(stage);
            }
        });
        table.add(this.btnMenuScrip).bottom().right().size(stage.getViewport().getWorldHeight() / 4, stage.getViewport().getWorldHeight() / 4);
        return table;
    }

    private void showNote() {
        if (actors1.size != 0) {
            btnMenuScrip.setText(actors1.get(0).getNote());
            btnMenuScrip.addAction(sequence(delay(1.0f), run(new Runnable() {
                public void run() {
//                    System.out.println("Action complete!");
                    btnMenuScrip.setText("?");
                }
            })));
        }
    }

    private Table buildBackgroundLayer() {
        Table table = new Table();
        table.setBackground(directrgame.gameSkin.getDrawable("backgroundGame"));
//        table.debug();
        table.setSize(stage.getViewport().getWorldWidth(), stage.getViewport().getWorldHeight());
        table.setPosition(0.0f, 0.0f);
        znakImg = new Image(this.directrgame.gameSkin, "ScripGorZnak");
        znakImg.setPosition(0, this.stage.getViewport().getWorldHeight() / 2.7f);
        table.addActor(znakImg);

        leftBorder = new Image(Assets.instance.decoration.leftBorder);
        leftBorder.setSize(this.stage.getViewport().getWorldWidth() / 90, this.stage.getViewport().getWorldHeight() / 4f);
        leftBorder.setPosition(this.stage.getViewport().getWorldWidth() / 23f * 8f - (this.stage.getViewport().getWorldWidth() / 90 - 1), 0);
        table.addActor(leftBorder);

        rightBorder = new Image(Assets.instance.decoration.rightBorder);
        rightBorder.setSize(this.stage.getViewport().getWorldWidth() / 90, this.stage.getViewport().getWorldHeight() / 4f);
        rightBorder.setPosition(this.stage.getViewport().getWorldWidth() / 23f * 15f, 0);
        table.addActor(rightBorder);

        KeyGorizPack keyGorizPack;

        for (int i = 8; i < 15; i++) {
            keyGorizPack = new KeyGorizPack(directrgame, i - 7, stage, i);
            final int finalI = i;
            keyGorizPack.addListener(new ClickListener() {
                //            @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                    ScripPracticeScreen.this.onLevelSelectClicked(finalI);
                    KeyGorizPack key = (KeyGorizPack) event.getListenerActor();
                    Assets.play(key.getKey() + 4);
                    if (actors1.size != 0) {
                        if (key.getKey() == actors1.get(0).getKey()) {
                            key.status = 2;//green
                            if (!showNote) {
                                score += 5;
                            }
                            showNote = false;
                        } else {
                            key.status = 3;//red
                            actors1.get(0).showTitle = true;
                        }
                        actors1.get(0).isNoteBlack = false;
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
//        renderGuiFpsCounter();
        if (directrgame.gameStatus == "action"){
            controller();
        }

    }


    private void Back() {
        this.directrgame.setScreen(new ScripPackScreen(this.directrgame));
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

//    public class MyTextButton extends TextButton {
//
//        public MyTextButton(String text, TextButtonStyle style,EventListener listener) {
//            super(text, style);
//            addListener(listener);
//        }


//    }

}
