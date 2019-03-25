package com.insomnian.note.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.insomnian.note.enums.GameState;
import com.insomnian.note.game.Assets;
import com.insomnian.note.screens.DirectedGame;


public class BlackNote extends Actor {

    private final int number;
    private final Stage stage;
    private final Vector2 position;
    private final float height;
    private final float width;
    private final DirectedGame game;
    private final TextureRegion lineImg;
    private final float originX;
    private float fontSize;
    private TextureRegion textureRegion;
    public boolean isNoteBlack = true;
    public boolean showTitle = false;
    private final BitmapFont font;
    private String note;
    private int key;
    private Array<BlackNote> arr;
    float noteSize = 0;
    private String status = "action";

    public BlackNote(DirectedGame game, int number, Stage stage, float widhtTop, float widthBot, Array arr) {
        this.arr = arr;
        this.game = game;
        this.number = number;
        this.stage = stage;
        originX = getOriginX();
        position = new Vector2(stage.getViewport().getWorldWidth(), ((this.stage.getViewport().getWorldHeight() - this.stage.getViewport().getWorldHeight() / 4f - 50) / 23f) * number + this.stage.getViewport().getWorldHeight() / 4f);
        this.width = widthBot / 9.2f;
        this.height = widthBot / 13f;
        this.font = Assets.instance.fonts.defaultNormal;
//        font.setColor(0.11f,0.11f, 0.11f, 1);
        font.setColor(Color.valueOf("071d53"));

        lineImg = Assets.instance.decoration.lineImg;
        nameNote();

        note = Assets.languageNoteName(note);
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font, note);
        noteSize = glyphLayout.width;
    }

    public String getNote() {
        return note;
    }

    private void nameNote() {
        if ((number == 0) || (number == 7) || (number == 21) || (number == 14)) {
            note = "Mi";
            key = 3;
//            System.out.println("Mi");
        }
        if ((number == 1) || (number == 8) || (number == 22) || (number == 15)) {
            note = "Fa";
            key = 4;
//            System.out.println("Fa");
        }
        if ((number == 2) || (number == 9) || (number == 16)) {
            note = "Sol";
            key = 5;
//            System.out.println("Sol");
        }
        if ((number == 3) || (number == 10) || (number == 17)) {
            note = "La";
            key = 6;
//            System.out.println("La");
        }
        if ((number == 4) || (number == 11) || (number == 18)) {
            note = "Si";
            key = 7;
//            System.out.println("Si");
        }
        if ((number == 5) || (number == 12) || (number == 19)) {
            note = "Do";
            key = 1;
//            System.out.println("Do");
        }
        if ((number == 6) || (number == 13) || (number == 20)) {
            note = "Re";
            key = 2;
//            System.out.println("Re");
        }


//        System.out.println("noteSize "+noteSize);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (isNoteBlack) {
            textureRegion = Assets.instance.note.noteBlackGor;
        } else {
            textureRegion = Assets.instance.note.note_greyGor;
        }

        float pole = this.stage.getViewport().getWorldHeight() - this.stage.getViewport().getWorldHeight() / 4f - 50;
        float keyH = this.stage.getViewport().getWorldHeight() / 4f;
        float widthW = this.stage.getViewport().getWorldWidth();
        float hidthH = stage.getViewport().getWorldHeight();

        if ((number == 5) || (number == 4)) {
//            batch.draw(lineImg,po sition.x - 10 , 208,70,2);
            batch.draw(lineImg, position.x - 27, pole / 46 * 12 + keyH, widthW / 13, hidthH / 200);
        }
        if ((number == 3) || (number == 2)) {
            batch.draw(lineImg, position.x - 27, pole / 46 * 12 + keyH, widthW / 13, hidthH / 200);
            batch.draw(lineImg, position.x - 27, pole / 46 * 8 + keyH, widthW / 13, hidthH / 200);
        }
        if ((number == 1) || (number == 0)) {
            batch.draw(lineImg, position.x - 27, pole / 46 * 12 + keyH, widthW / 13, hidthH / 200);
            batch.draw(lineImg, position.x - 27, pole / 46 * 8 + keyH, widthW / 13, hidthH / 200);
            batch.draw(lineImg, position.x - 27, pole / 46 * 4 + keyH, widthW / 13, hidthH / 200);
        }
        if ((number == 17) || (number == 18)) {
            batch.draw(lineImg, position.x - 27, pole / 46 * 36 + keyH, widthW / 13, hidthH / 200);
        }
        if ((number == 19) || (number == 20)) {
            batch.draw(lineImg, position.x - 27, pole / 46 * 36 + keyH, widthW / 13, hidthH / 200);
            batch.draw(lineImg, position.x - 27, pole / 46 * 40 + keyH, widthW / 13, hidthH / 200);
        }
        if (number == 21 || number == 22) {
            batch.draw(lineImg, position.x - 27, pole / 46 * 36 + keyH, widthW / 13, hidthH / 200);
            batch.draw(lineImg, position.x - 27, pole / 46 * 40 + keyH, widthW / 13, hidthH / 200);
            batch.draw(lineImg, position.x - 27, pole / 46 * 44 + keyH, widthW / 13, hidthH / 200);
        }
        batch.draw(textureRegion, position.x, position.y + 6, width, height);

        if (showTitle) {
//            font.draw(batch, note, position.x , position.y + 53f);
            Float center = width / 2 - noteSize / 2;
            font.draw(batch, note, position.x + center, position.y + 53f);
        }
    }

    public int getKey() {
        return key;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public void act(float delta) {

//        stateTime += Gdx.graphics.getDeltaTime();

    if  (game.gameState == GameState.MOVE){
        position.x -= 130 * delta;
        }
        if (position.x <= 110) {

            remove();
//            for (int i = 0; i < arr.size; i++) {
//                System.out.print(i + "-" + arr.get(i).getNote() + " ");
//            }
//            System.out.println("remove" + arr.get(0).getNote());
            if (isNoteBlack) {
                arr.removeIndex(0);
            }
//                        System.out.println(actors1.get(0).getKey() + " number");
        }
    }
}
