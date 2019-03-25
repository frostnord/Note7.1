package com.insomnian.note.actors;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.insomnian.note.Note;
import com.insomnian.note.game.Assets;
import com.insomnian.note.game.WorldController;
import com.insomnian.note.screens.DirectedGame;
import com.insomnian.note.screens.ScripMiddleScreen;
import com.insomnian.note.screens.ScripLeftScreen;
import com.insomnian.note.utils.SoundManager;

import java.lang.reflect.Field;

public class KeyVert extends Actor {

    private final TextureRegion triangleTextureRegion;
    private final TextureRegion lineTextureRegion;
    private TextureRegion keyTextureRegion;
    private static float textuerKeybordHeight;
    private Stage stage;
    private AtlasRegion atlasRegion;
    private float width;
    private float height;
    private float position;
    private DirectedGame directedGame;
    private Field NUMBER;
    private Screen screen;
    public int state;
    public int number;
    public int key;


    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(keyTextureRegion, position, 0, width, height);

        if (!((number % 2) == 0)) {
            batch.draw(triangleTextureRegion, position, height - 1, width, height / 10);
        }
        if ((number == 7) || (number == 9) || (number == 11) || (number == 13) || (number == 15)) {
            float lineWidth = width / 10;
            batch.draw(lineTextureRegion,
                    position + width / 2 - lineWidth / 2,
                    height,
                    width / 10,
                    stage.getViewport().getWorldHeight() / 1.5f);///////////////
        }
    }

    public KeyVert(final DirectedGame directedGame, final int key, final Stage stage, final int number) {
        this.number = number;
        this.directedGame = directedGame;
        this.stage = stage;
        this.position = (this.stage.getViewport().getWorldWidth() / 23) * number;
        this.width = this.stage.getViewport().getWorldWidth() / 23 + 1;
        this.height = this.stage.getViewport().getWorldHeight() / 3.5f;

        this.key = key;

        switch (key) {
            case 1:
                keyTextureRegion = Assets.instance.noteImg.doKeyImgActor;
                break;
            case 2:
                keyTextureRegion = Assets.instance.noteImg.reKeyImgActor;
                break;
            case 3:
                keyTextureRegion = Assets.instance.noteImg.miKeyImgActor;
                break;
            case 4:
                keyTextureRegion = Assets.instance.noteImg.faKeyImgActor;
                break;
            case 5:
                keyTextureRegion = Assets.instance.noteImg.solKeyImgActor;
                break;
            case 6:
                keyTextureRegion = Assets.instance.noteImg.laKeyImgActor;
                break;
            case 7:
                keyTextureRegion = Assets.instance.noteImg.siKeyImgActor;
                break;
        }
        triangleTextureRegion = Assets.instance.decoration.triangleImg;
        lineTextureRegion = Assets.instance.decoration.lineImg;
        this.state = 0;
//        isTouchable();
//        setTouchable(Touchable.enabled);
        setBounds(position, 0, width, height);
        addListener(new ClickListener() {
            //            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println(x);
                System.out.println(y);
                if (key == 1) {
                    if (WorldController.KEYNUMBER == number) {
                        keyTextureRegion = Assets.instance.noteImg.doGreenKeyImgActor;
                    } else {
                        keyTextureRegion = Assets.instance.noteImg.doRedKeyImgActor;
                    }
                } else if (key == 2) {
                    if (WorldController.KEYNUMBER == number) {
//                            || (ScripMiddleScreen.getNoteActors().get(0).getIndex() == number)) {
                        keyTextureRegion = Assets.instance.noteImg.reGreenKeyImgActor;
                    } else {
                        keyTextureRegion = Assets.instance.noteImg.reRedKeyImgActor;
                    }
                } else if (key == 3) {
                    if (WorldController.KEYNUMBER == number) {
//                        ||(ScripMiddleScreen.getNoteActors().get(0).getIndex() == number)) {
                        keyTextureRegion = Assets.instance.noteImg.miGreenKeyImgActor;
                    } else {
                        keyTextureRegion = Assets.instance.noteImg.miRedKeyImgActor;
                    }
                } else if (key == 4) {
                    if (WorldController.KEYNUMBER == number){
//                            || (ScripMiddleScreen.getNoteActors().get(0).getIndex() == number)) {
                        keyTextureRegion = Assets.instance.noteImg.faGreenKeyImgActor;
                    } else {
                        keyTextureRegion = Assets.instance.noteImg.faRedKeyImgActor;
                    }
                } else if (key == 5) {
                    if (WorldController.KEYNUMBER == number) {
//                        || (ScripMiddleScreen.getNoteActors().get(0).getIndex() == number)) {
                        keyTextureRegion = Assets.instance.noteImg.solGreenKeyImgActor;
                    } else {
                        keyTextureRegion = Assets.instance.noteImg.solRedKeyImgActor;
                    }
                } else if (key == 6) {
                    if (WorldController.KEYNUMBER == number) {
//                            || (ScripMiddleScreen.getNoteActors().get(0).getIndex() == number)) {
                        keyTextureRegion = Assets.instance.noteImg.laGreenKeyImgActor;
                    } else {
                        keyTextureRegion = Assets.instance.noteImg.laRedKeyImgActor;
                    }
                } else if (key == 7) {
                    if (WorldController.KEYNUMBER == number) {
//                            || (ScripMiddleScreen.getNoteActors().get(0).getIndex() == number)) {
                        keyTextureRegion = Assets.instance.noteImg.siGreenKeyImgActor;
                    } else {
                        keyTextureRegion = Assets.instance.noteImg.siRedKeyImgActor;
                    }
                }
                if (directedGame.getScreen().getClass() == ScripLeftScreen.class) {
                    ScripLeftScreen.firstActor.setNoteCliked(true);
                }
                Assets.play(number);
                return true;
            }

            //            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                switch (key) {
                    case 1:
                        keyTextureRegion = Assets.instance.noteImg.doKeyImgActor;
                        break;
                    case 2:
                        keyTextureRegion = Assets.instance.noteImg.reKeyImgActor;
                        break;
                    case 3:
                        keyTextureRegion = Assets.instance.noteImg.miKeyImgActor;
                        break;
                    case 4:
                        keyTextureRegion = Assets.instance.noteImg.faKeyImgActor;
                        break;
                    case 5:
                        keyTextureRegion = Assets.instance.noteImg.solKeyImgActor;
                        break;
                    case 6:
                        keyTextureRegion = Assets.instance.noteImg.laKeyImgActor;
                        break;
                    case 7:
                        keyTextureRegion = Assets.instance.noteImg.siKeyImgActor;
                        break;
                }
            }
        });
    }

    public boolean isTouched() {
        return Gdx.input.justTouched();
    }


    public static float getTextuerKeybordHeight() {
        return textuerKeybordHeight;
    }

    public float getRigth() {
        return position;
    }

    //    public Actor hit (float x, float y, boolean touchable) {
//
//    }

}