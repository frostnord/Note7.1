package com.insomnian.note.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.insomnian.note.Note;
import com.badlogic.gdx.Input;
import com.insomnian.note.game.Assets;

/**
 * Created by 1 on 28.10.2015.
 */
public class SplashScreen implements Screen {

//    private static final String IMAGES_ACAROLABS = "acarolabs.png";
    private static final String SOUNDS_SPLASH = "01-arkasia-destiny.mp3";
    private final Note game;
//    private boolean isSplashFinish;
    private Music music;
    private Image splashImage;
//    private Stage stage = new Stage(new StretchViewport(800.0f, 480.0f));

    float alpha;
    SpriteBatch batch;
    float delay;
    Texture imgLogo;
    float timer;

    public SplashScreen(Note note) {
        this.game = note;
//        Texture texture = new Texture(Gdx.files.internal(IMAGES_ACAROLABS));
//        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
//        this.splashImage = new Image(texture);
//        float y = 240.0f - (this.splashImage.getHeight() / 2.0f);
//        this.splashImage.setX(400.0f - (this.splashImage.getWidth() / 2.0f));
//        this.splashImage.setY(y);
//        this.stage.addActor(this.splashImage);
//        this.isSplashFinish = false;
    }

    @Override
    public void show() {

        this.delay = 0.0F;
        this.timer = 3.0F;
        this.alpha = 0.0F;
        this.batch = new SpriteBatch();
//        this.imgLogo = new Texture("LoadScreen-" + this.game.densite + ".png");
        this.imgLogo = new Texture("LoadScreen.png");

        this.music = Gdx.audio.newMusic(Gdx.files.internal(SOUNDS_SPLASH));
        this.music.play();
//        this.splashImage.addAction(Actions.sequence(Actions.alpha(0.0f), Actions.fadeIn(0.5f)));
//        AssetsLoader.load();

        Assets.instance.load(game.manager);
        this.game.manager.load("sprites.atlas", TextureAtlas.class);
        this.game.manager.load("ui.atlas",TextureAtlas.class);
        this.game.manager.finishLoading();
//
        this.game.uiSkin = new Skin(Gdx.files.internal("ui.json"),new TextureAtlas(("ui.atlas")));
        this.game.gameSkin = new Skin(Gdx.files.internal("sprites.json"), new TextureAtlas("sprites.atlas"));


        Assets.instance.init(this.game.manager);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1.0f, 0.0f, 1.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        this.stage.draw();
//        this.stage.act();
        this.batch.begin();
//            this.batch.setColor(1.0F, 1.0F, 1.0F, this.alpha);
        this.batch.draw(this.imgLogo, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.batch.end();

        if (game.manager.update()&& !this.music.isPlaying() ) {
//            this.splashImage.addAction(Actions.sequence(Actions.fadeOut(0.5f), Actions.alpha(0.0f), Actions.run(new Runnable() {
//                public void run() {

            SplashScreen.this.game.setScreen(new FirstMenuScreen(this.game));
//            SplashScreen.this.game.setScreen(new ScripPackScreen(this.game));
//                }
//            })));
        }



//            if (Gdx.input.justTouched()) {
//                this.timer = 3.0F;
//            }
//            if ((this.alpha < 0.9D) && (this.timer == 0.0F)) {
//                this.alpha += delta;
//            } else {
//                this.timer += delta;
//                if (this.timer > 2.0F) {}
//                for (this.alpha -= delta;; this.alpha = 1.0F)
//                {
//                    if (this.alpha > 0.0F) {
//                        break;
//                    }
//                    this.alpha = 0.0F;
////                    this.game.typeScreen = "intro";
//                    this.game.setScreen(new FirstMenuScreen(this.game));
//                    break;
//                }
//            }
        }


    @Override
    public void resize(int width, int height) {
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
//        this.stage.dispose();
    }
}
