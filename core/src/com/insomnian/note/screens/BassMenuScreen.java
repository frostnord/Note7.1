package com.insomnian.note.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.insomnian.note.enums.GameState;
import com.insomnian.note.game.WorldController;
import com.insomnian.note.utils.Constants;
import com.insomnian.note.utils.GameManager;


 public class BassMenuScreen extends AbstractGameScreen  {

        private int Height;

        private int Width;

        private Table layerBackground;
        private Image imgBackground;
        //    private TextureAtlas atlas;
        private Stage stage;
        private Table layerControls;
        private Button treningMenuImg;
        private Button practiceMenuImg;
        private Button lerningMenuImg;
        private Image keybordImg;
        private float keybordHeight;
        private Image lineImg;
        private Table layerKeyboard;//////
        private Table layerLines;


        public BassMenuScreen(DirectedGame directedGame) {
            super(directedGame);
            WorldController.setGameModeBass();

//        this.Height = Gdx.graphics.getHeight();
////        System.out.println( Height);
//        this.Width = Gdx.graphics.getWidth();
        }

        private void rebuildStage() {
            this.buildMenuLayers();
            this.assembleStage();////////////////

//        this.treningMenuImg = new Image(this.directedGame.gameSkin, "TreningScrip_left");
//        float f1 = this.Width / 5f;
//        float f2 = treningMenuImg.getHeight() * f1 / treningMenuImg.getWidth();
//        this.treningMenuImg.setPosition(this.Width - this.Width / 30 - f1, this.Width / 30);
//        this.treningMenuImg.setSize(f1, f2);

        }
        private void assembleStage() {
            this.stage.clear();
            Stack stack = new Stack();
//        stack.setTransform(true);
            this.stage.addActor(stack);
            stack.setSize(this.stage.getViewport().getWorldWidth(), this.stage.getViewport().getWorldHeight());
            stack.add(this.layerBackground);
//        stack.add(this.layerKeyboard);
//        stack.add(this.layerLines);
            stack.add(this.layerControls);

        }
        private Table buildKeyboardLayer() {
            final Table table = new Table();
//        table.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            table.center().bottom();
            this.keybordImg = new Image(this.directedGame.gameSkin, "keybord");
            table.add(this.keybordImg);
            keybordHeight = keybordImg.getTop();
            return table;
        }
        private Table buildLinesLayer() {
            Table table = new Table();
            table.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            table.bottom().left().padBottom(keybordHeight);
            this.lineImg = new Image(this.directedGame.gameSkin, "lines");
            table.add(this.lineImg);

            return table;
        }
        private void buildMenuLayers() {
            this.layerBackground = this.buildBackgroundLayer();

            this.layerKeyboard=this.buildKeyboardLayer();
//        this.layerLines = this.buildLinesLayer();
            this.layerControls = this.buildControlsLayer();
//        this.layerSettings = this.buildSettingsLayer();
        }
        private Table buildBackgroundLayer() {
            Table table = new Table();
//        table.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            this.imgBackground = new Image(this.directedGame.gameSkin,"backgroundMenu");
            table.add(this.imgBackground).fill().expand();

            return table;
        }
        private Table buildControlsLayer() {
            Table table = new Table();
//        table.debug();
//        table.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            table.center().bottom();
//        .padBottom(this.directedGame.gameSkin.getRegion("ScripButton").getRegionWidth() / 1.5f);

            this.treningMenuImg = new Button(this.directedGame.gameSkin, "TreningScrip_left");
            table.add(this.treningMenuImg);
            this.treningMenuImg.addListener(new ChangeListener() {

                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {/////////
//                FirstMenuScreen.this.onPlayClicked();
//                System.out.println("dsdsd");?
//                    onTreningClicked();
                        BassMenuScreen.this.directedGame.setScreen(new BassLeftScreen(directedGame));
                }
            });

            this.practiceMenuImg = new Button(this.directedGame.gameSkin, "TreningScrip_mid");///"LearningScrip_mid"
            table.add(this.practiceMenuImg).padLeft(this.stage.getViewport().getWorldWidth()/11.0f);
            this.practiceMenuImg.addListener(new ChangeListener() {

                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {
//                    onLearningClicked();
                    BassMenuScreen.this.directedGame.setScreen(new BassMiddleScreen(directedGame));
                }
            });

            this.lerningMenuImg = new Button(this.directedGame.gameSkin, "TreningScrip_prew");///"PracticeScrip_right"
            table.add(this.lerningMenuImg).padLeft(this.stage.getViewport().getWorldWidth()/11.0f );
            this.lerningMenuImg.addListener(new ChangeListener() {

                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {
                    BassMenuScreen.this.directedGame.setScreen(new BassPackScreen(directedGame));
//                    onPracticeClicked();
                }
            });
//        System.out.println(this.directedGame.gameSkin.getRegion("LearningScrip_mid").getRegionHeight() /2.5f);
            return table;
        }

        private void onLearningClicked() {
            this.directedGame.setScreen(new ScripMiddleScreen(this.directedGame));
        }

        private void onTreningClicked() {
            this.directedGame.setScreen(new ScripLeftScreen(this.directedGame));
        }
        private void onPracticeClicked() {
            this.directedGame.setScreen(new ScripPackScreen(this.directedGame));
        }

        @Override
        public void render(float delta) {
            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        Gdx.gl.glClear(16384);
            stage.act(delta);
            stage.draw();
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
//        this.directedGame.camera.viewportWidth = Gdx.graphics.getWidth();
//        this.directedGame.camera.viewportHeight = Gdx.graphics.getHeight();
        }

        @Override
        public void hide() {
            this.stage.dispose();
        }

        @Override
        public void dispose() {
            this.stage.dispose();
        }

        //    @Override
//    public InputProcessor getInputProcessor() {
//        return null;
//    }
        @Override
        public void show() {

//        this.stage = new Stage();
//        this.directedGame.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

            Gdx.input.setCatchBackKey(true);
            this.stage = new Stage(new ExtendViewport(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT,directedGame.camera)){
                @Override
                public boolean keyUp(int keycode) {

                    if ((keycode == Input.Keys.BACK)|| (keycode == Input.Keys.ESCAPE)){

                        BassMenuScreen.this.directedGame.setScreen(new FirstMenuScreen(directedGame));
//                        com.insomnian.note.screens.ScripMenuScreen.this.Back();
                    }
                    return false;
                }
            };
            Gdx.input.setInputProcessor(stage);
//        this.stage.setViewport(new StretchViewport(800.0f, 480.0f));
            GameManager.ourInstance.setGameState(GameState.MOVE);
//        this.atlas = (TextureAtlas)this.directedGame.assetManager.get("sprites.atlas", TextureAtlas.class);
            this.rebuildStage();

        }

//        private void Back() {
//            this.directedGame.setScreen(new FirstMenuScreen(this.directedGame));
//        }

    }


