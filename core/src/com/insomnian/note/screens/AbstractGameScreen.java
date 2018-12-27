package com.insomnian.note.screens;

import com.badlogic.gdx.Screen;
import com.insomnian.note.Note;
import com.insomnian.note.game.Assets;

/**
 * Created by 1 on 13.04.2015.
 */
public abstract class AbstractGameScreen implements Screen {

    protected Note game;

    public AbstractGameScreen(Note directedGame) {

        this.game = directedGame;
    }
    @Override
    public void dispose() {
        Assets.instance.dispose();
    }

//    public abstract InputProcessor getInputProcessor();

    @Override
    public abstract void hide();

    @Override
    public abstract void pause();

    @Override
    public abstract void render(float var1);

    @Override
    public abstract void resize(int var1, int var2);

    @Override
    public void resume() {
    }

    @Override
    public abstract void show();
}
