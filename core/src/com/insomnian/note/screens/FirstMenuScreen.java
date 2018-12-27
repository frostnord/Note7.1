package com.insomnian.note.screens;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.*;
import com.insomnian.note.Note;
import com.insomnian.note.actors.NoteVert;
import com.insomnian.note.game.Assets;
import com.insomnian.note.utils.Constants;
import com.insomnian.note.utils.GamePreferences;

public class FirstMenuScreen extends AbstractGameScreen  {

    private static final String TAG = FirstMenuScreen.class.getName();

    private Table layerBackground;
    private Image imgBackground;
    private Stage stage;
    private TextureAtlas atlas;
    private Table layerKeyboard;

//    private Table layerSettings;
    private Table layerControls;
    private Button btnMenuScrip;
    private Button btnMenuBass;
    private Button settingsMenuImg;
    private Table layerSettings;
    private Image keybordImg;
    private float keybordHeight;
    private Image lineImg;
    private Table layerLines;
    private NoteVert oneMenuNoteVert;
    private Table layerNote;
    private OrthographicCamera camera;
    private Vector2 screenSize;
    private float sizeModifier;
    private Button btnMenuPlay;
    private Dialog optDialog;


    public FirstMenuScreen(Note directedGame) {
        super(directedGame);

//        statusMusic();
    }
//        this.game = game;
//        ScripTextureRegion = new  TextureRegion(AssetsManager.getTextureAtlas().findRegion(Constants.SCRIP_BUTTON_REGION_NAME));
//        SettingsRegion = new  TextureRegion(AssetsManager.getTextureAtlas().findRegion(Constants.SETTINGS_REGION_NAME));
//        BassTextureRegion = new  TextureRegion(AssetsManager.getTextureAtlas().findRegion(Constants.BASS_BUTTON_REGION_NAME));
//        settingsImage = new Image(SettingsRegion);
//        scripImage = new Image(ScripTextureRegion);
//        bassImage = new Image(BassTextureRegion);


//        settingsImage.addListener(new ClickListener(){
//            @Override
//            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
////                Gdx.input.vibrate(20);
//                System.out.println("111");
//                return true;
//            };
//            @Override
//            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
////                game.setScreen(new LevelScreen(game));
////                dispose();
//            };
//        } );
//        scripImage.addListener(new ClickListener() {
//            @Override
//            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
////                Gdx.input.vibrate(20);
//                System.out.println("111");
//                return true;
//            };
//            @Override
//            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                game.setScreen(new ScripMenuScreen(game));
//                dispose();
//            };
//        });
//        bassImage.addListener(new ClickListener() {
//            @Override
//            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
////                Gdx.input.vibrate(20);
//                System.out.println("222");
//                return true;
//            };
//            @Override
//            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
////                game.setScreen(new ScripMenuScreen(game));
////                dispose();
//            };
//        });


//        table = new Table();
//
//
//        table.setFillParent(true);
//        table .right().top().pad(20);
//
//        table.add(settingsImage).colspan(2).right().expandX().padRight(10).padTop(30) ;
//        table.row();
//        table.add(scripImage).size(200,200).padTop(60).padLeft(50) ;
//        table.add(bassImage).size(200,200).padTop(60).padRight(50);
//        System.out.println(scripImage.getWidth());
////        table.row();
//
//
//        table.setDebug(true);//////////////////////////////////
//
//
////        table.row();
////        table.add(exit);
//        stage.addActor(table);

    private Table buildBackgroundLayer() {
        Table table = new Table();
        this.imgBackground = new Image(this.game.gameSkin.getRegion("backgroundMenu"));
        table.add(this.imgBackground).fill().expand();
        return table;
    }

    private Table buildSettingsLayer() {
        Table table = new Table();

        table.left().top().padLeft(this.game.gameSkin.getRegion("SetingsButton").getRegionWidth() / 4).padTop(this.game.gameSkin.getRegion("SetingsButton").getRegionWidth() / 4);
        this.settingsMenuImg = new Button(this.game.gameSkin, "SetingsButton");
//        this.settingsMenuImg.setSize(Constants.MENU_BUTTON_SIZE, Constants.MENU_BUTTON_SIZE);
        table.add(this.settingsMenuImg);
        this.settingsMenuImg.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
//                FirstMenuScreen.this.onPlayClicked();
                optDialog.show(stage);
            }
        });
        return table;
    }
    private void statusMusic(){
        if (GamePreferences.instance.isMusicEnabled()){
            Assets.instance.music.menuMusic.play();
        }
    }

    private void optionsDialogInit() {
        layerSettings =new Table();
        optDialog = new Dialog("", Assets.instance.skin.windowStyle);
        optDialog.getContentTable().setWidth(700);
//        optDialog.setModal(true);
//        optDialog.center();
        optDialog.setMovable(false);
        optDialog.pad(60);
//        optDialog.setWidth(600);
//        optDialog.text(new Label("Setings", new Label.LabelStyle(Assets.instance.fonts.levelComplete, Color.WHITE)));
        final Button musicCheckBox = new CheckBox("", game.uiSkin, "music");
        musicCheckBox.setChecked(GamePreferences.instance.isMusicEnabled());///вроде задает состояние
        musicCheckBox.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                boolean isMusicOn = musicCheckBox.isChecked();
                GamePreferences.instance.setMusicEnabled(isMusicOn);
//                musicManager.setEnabled(isMusicOn);
                Assets.instance.music.menuMusic.stop();
                statusMusic();
            }
        });
        final Button soundCheckBox = new CheckBox("", game.uiSkin, "sound");
        soundCheckBox.setChecked(GamePreferences.instance.isSoundEnabled());
        soundCheckBox.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                boolean isSoundOn = soundCheckBox.isChecked();
                GamePreferences.instance.setSoundEnabled(isSoundOn);
//                Assets.instance.music.menuMusic.stop();
            }
        });
        String languageRu ;
        if (GamePreferences.instance.languageRu()){
            languageRu ="Do Re Mi";
        }else{
            languageRu="C D F";
        }
        final Button languageCheckBox = new CheckBox("", game.uiSkin, "language");/// доделать языки
        final Label languageLabel = new Label(languageRu, new Label.LabelStyle(Assets.instance.fonts.levelCompleted,Color.WHITE));
        languageCheckBox.setChecked(GamePreferences.instance.languageRu());
        languageCheckBox.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                boolean languageRuTrue = languageCheckBox.isChecked();
                GamePreferences.instance.setLanguage(languageRuTrue);
                if (languageRuTrue){
                    languageLabel.setText("Do Re Mi");
                }else{
                    languageLabel.setText("C D E");
//                    languageLabel.setAlignment(Align.center);
                }
//                musicManager.setEnabled(isMusicOn);
//                Assets.instance.music.menuMusic.stop();
//                statusMusic();
            }
        });

        Label musicLabel = new Label("Music", new Label.LabelStyle(Assets.instance.fonts.levelCompleted,Color.WHITE));
        Label soundLabel = new Label("Sound", new Label.LabelStyle(Assets.instance.fonts.levelCompleted,Color.WHITE));

//        optDialog.debugAll();
        optDialog.getContentTable().setWidth(600);
        optDialog.getContentTable().add(new Label("Settings", new Label.LabelStyle(Assets.instance.fonts.levelCompleted, Color.WHITE))).colspan(2);
        optDialog.getContentTable().row().padBottom(30).fill().expand();
        optDialog.getContentTable().add((Actor) musicCheckBox).size(150, 150);
        optDialog.getContentTable().add(musicLabel).padLeft(10);
        optDialog.getContentTable().row().padBottom(30).fill().expand();
        optDialog.getContentTable().add((Actor) soundCheckBox).size(150, 150);
        optDialog.getContentTable().add(soundLabel).padLeft(10);
        optDialog.getContentTable().row().padBottom(30).fill().expand();
        optDialog.getContentTable().add((Actor) languageCheckBox).size(150, 150);
        optDialog.getContentTable().add(languageLabel).width(450).padLeft(10);
        optDialog.getContentTable().row().padBottom(30).fill().expand();
        final TextButton oKbutton = new TextButton("Ok",Assets.instance.skin.optionDiologTextButtonStyle);
        oKbutton.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                GamePreferences.instance.flush();
                optDialog.hide();
            }
        });
        optDialog.getContentTable().add(oKbutton).colspan(2).size(150,150);
}

    private void onPlayClicked() {
        this.game.setScreen(new ScripMenuScreen(this.game));
    }

    private Table buildControlsLayer() {
        final Table table = new Table();
//        table.debug();
//        table.center();
        table.center().bottom();
//        table.setFillParent(true);

//
        this.btnMenuScrip = new Button(Assets.instance.skin.buttonStyle);
        Image imgMenuScrip = new Image(this.game.gameSkin, "ScripButton");
        imgMenuScrip.setOrigin(imgMenuScrip.getWidth() / 2.0f, imgMenuScrip.getHeight() / 2.0f);
        this.btnMenuScrip.add((Actor) imgMenuScrip);
        this.btnMenuScrip.setOrigin(btnMenuScrip.getWidth() / 2.0f, btnMenuScrip.getHeight() / 2.0f);

//        this.btnMenuScrip.setPosition(100,100);
//        table.add(this.btnMenuScrip).size(260.0f * this.sizeModifier);/////////////////////////////
//        table.add(this.btnMenuScrip).size(Constants.VIEWPORT_GUI_WIDTH /4f ,Constants.VIEWPORT_GUI_WIDTH /4f*  Constants.ASPECT_RATIO);/////////////////////////////
//        System.out.println(stage.getViewport().getWorldWidth() / 4);
        this.btnMenuScrip.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                FirstMenuScreen.this.onPlayClicked();/////////////////////
            }
        });
        table.add(this.btnMenuScrip);

        this.btnMenuBass = new Button(Assets.instance.skin.buttonStyle);
        Image imgMenuBass = new Image(this.game.gameSkin, "BassButton");
        imgMenuBass.setOrigin(imgMenuBass.getWidth() / 2.0f, imgMenuBass.getHeight() / 2.0f);
        this.btnMenuBass.add((Actor) imgMenuBass);
        this.btnMenuBass.setOrigin(btnMenuBass.getWidth() / 2.0f, btnMenuBass.getHeight() / 2.0f);
        this.btnMenuBass.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
//                MenuScreen.this.onStoreClicked();
            }
        });
        table.add(this.btnMenuBass).padLeft((this.stage.getViewport().getWorldWidth() / 11.0f));

        this.btnMenuPlay = new Button(Assets.instance.skin.buttonStyle);
        Image imgMenuPlay = new Image(this.game.gameSkin, "PlayButton");
        imgMenuPlay.setOrigin(imgMenuPlay.getWidth() / 2.0f, imgMenuPlay.getHeight() / 2.0f);
        btnMenuPlay.add((Actor) imgMenuPlay);
        btnMenuPlay.setOrigin(btnMenuPlay.getWidth() / 2.0f, btnMenuPlay.getHeight() / 2.0f);
        this.btnMenuBass.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
//                MenuScreen.this.onStoreClicked();
            }
        });
        table.add(this.btnMenuPlay).padLeft((this.stage.getViewport().getWorldWidth() / 11.0f));
        table.row();
        Image imgScripReflect = new Image(this.game.gameSkin, "ReflectScrip");
        Image imgBassReflect = new Image(this.game.gameSkin, "ReflectBass");
        Image imgPlayReflect = new Image(this.game.gameSkin, "ReflectPlay");
        table.add((Actor) imgScripReflect);
        table.add((Actor) imgBassReflect).padLeft((this.stage.getViewport().getWorldWidth() / 11.0f));
        table.add((Actor) imgPlayReflect).padLeft((this.stage.getViewport().getWorldWidth() / 11.0f));
//        table.setFillParent(true);
//        table.addAction(Actions.fadeIn(2f));
//        table.pack();
        System.out.println(imgMenuScrip.getWidth() / 2.5f);
        return table;
    }

    private void rebuildStage() {
        this.buildMenuLayers();
        this.assembleStage();
        optionsDialogInit();
    }

    private void buildMenuLayers() {
        this.layerBackground = this.buildBackgroundLayer();
//        this.layerKeyboard=this.buildKeyboardLayer();
//        this.layerLines = this.buildLinesLayer();
//        this.layerNote = this.noteCreate();
        this.layerSettings = this.buildSettingsLayer();
        this.layerControls = this.buildControlsLayer();
    }

    private Table buildLinesLayer() {
        Table table = new Table();
        table.bottom().left().padBottom(keybordHeight);
        this.lineImg = new Image(this.game.gameSkin, "lines");
        table.add(this.lineImg);
        return table;
    }

    private void assembleStage() {
        this.stage.clear();
        Stack stack = new Stack();
        this.stage.addActor(stack);
        stack.setSize(this.stage.getViewport().getWorldWidth(), this.stage.getViewport().getWorldHeight());
//        stack.setSize(1280,720);

        stack.add(this.layerBackground);
//        stack.add(this.layerLines);
//        stack.add(this.layerNote);
        stack.add(this.layerSettings);
        stack.add(this.layerControls);
        stack.add(layerSettings);
    }

    private Table noteCreate() {
        Table table = new Table();
        table.addActor(oneMenuNoteVert = new NoteVert(game, stage));
        return table;
    }

    @Override
    public void show() {
//        camera = new OrthographicCamera();
//        this.camera.setToOrtho(false, this.screenSize.x, this.screenSize.y);

        statusMusic();
        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.stage = new Stage(new ExtendViewport(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT, camera)) {
            //        this.stage = new Stage(new ScreenViewport()){
//        this.stage = new Stage(new ExtendViewport(800,480)){
//        this.stage = new Stage(new StretchViewport(800,480)){
            @Override
            public boolean keyUp(int keycode) {
                if (keycode == Input.Keys.BACK) {
//                    MenuScreen.this.exitGame();
                    Gdx.app.exit();
                }
                return false;
            }

        };
//        camera.position.set(Constants.VIEWPORT_GUI_WIDTH / 2f , Constants.VIEWPORT_GUI_HEIGHT / 2f, 0);


//            this.game.manager.load("sprites.atlas", TextureAtlas.class);///////

        Gdx.input.setCatchBackKey(true);
//        this.stage = new Stage(){
//            @Override
//            public boolean keyUp(int keycode) {
//                if (keycode == Input.Keys.BACK) {
////                    MenuScreen.this.exitGame();
//                    Gdx.app.exit();
//                }
//                return false;
//            }
//        };
        Gdx.input.setInputProcessor(stage);



//        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        camera.position.set(0, 0, 0);
//        camera.update();
//        this.stage.setViewport(new FillViewport(800,480));

//        this.atlas = (TextureAtlas)this.game.manager.get("sprites.atlas", TextureAtlas.class); noooooooo
//

        this.rebuildStage();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
//        stage.getCamera().update();
//        camera.update();
//        if (oneMenuNoteVert.getPosition().y==keybordHeight+15) {
//            oneMenuNoteVert.remove();
//            oneMenuNoteVert =null;
//        }
//        if (oneMenuNoteVert ==null){
//            layerNote.addActor(oneMenuNoteVert = new NoteVert(game));
//        }
    }

    @Override
    public void resize(int n, int n2) {
        this.stage.getViewport().update(n, n2, true);
//        this.sizeModifier = (float)Math.min((int)n / 1080.0f, (int)n2) ;
//        camera.position.set(Constants.VIEWPORT_GUI_WIDTH / 2f, Constants.VIEWPORT_GUI_HEIGHT / 2f, 0);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {
//        Assets.instance.init(new AssetManager());
    }

    @Override
    public void hide() {
        this.stage.dispose();
    }

    @Override
    public void dispose() {
        stage.dispose();
//        Assets.instance.dispose();
    }
}
