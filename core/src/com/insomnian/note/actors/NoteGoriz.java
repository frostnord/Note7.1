package com.insomnian.note.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Align;
import com.insomnian.note.enums.GameMode;
import com.insomnian.note.enums.GameState;
import com.insomnian.note.game.Assets;
import com.insomnian.note.game.WorldController;
import com.insomnian.note.screens.DirectedGame;
import com.insomnian.note.utils.GameManager;

import java.util.Random;

/**
 * Created by 1 on 13.06.2015.
 */
public class NoteGoriz extends Actor {
    private final float width;
    private final float height;
    private final Stage stage;
    private final String noteName;
    private final float noteSize;
    private float widthBot;
    private TextureRegion textureRegion;
    private TextureRegion lineImg;
    private final DirectedGame game;
    private int index;
    private GameState gameState;
    private boolean isSecond;


    private Vector2 position;
    private String note ;
    public Vector2 dimension;
    public Vector2 origin;
    public Vector2 scale;
    public float rotation1;
    private BitmapFont font;
    private boolean move ;
    private int noteNumber;
    private float ran;
    private Animation noteAni;
    public float stateTime ;
    public Animation animation;
    private int ranNote ;
    private float rotation;
    private float widhtTop ;

    private int noteKey;

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        lineImg= Assets.instance.decoration.lineImg;

        if (note.equals("Do")){
            textureRegion = Assets.instance.note.noteRedDoGor;
        }else if (note.equals("Re")){
            textureRegion = Assets.instance.note.noteOrangeReGor;
        }else if (note.equals("Mi")){
            textureRegion = Assets.instance.note.noteYellowMiGor;
        }else if (note.equals("Fa")){
            textureRegion = Assets.instance.note.noteGreenFaGor;
        }else if (note.equals("Sol")){
            textureRegion = Assets.instance.note.noteBlueSolGor;
        }else if (note.equals("La")){
            textureRegion = Assets.instance.note.noteSiniiLaGor;
        }else if (note.equals("Si")){
            textureRegion = Assets.instance.note.notePurpleSiGor;
        }
        noteAni = Assets.instance.note.noteAni;

        float pole = this.stage.getViewport().getWorldHeight() - this.stage.getViewport().getWorldHeight() / 4f - 50;
        float keyH = this.stage.getViewport().getWorldHeight() / 4f;
        float widthW = this.stage.getViewport().getWorldWidth();
        float hidthH = stage.getViewport().getWorldHeight();

        if ((index== 5)||(index == 4)){
//            batch.draw(lineImg,po sition.x - 10 , 208,70,2);
            batch.draw(lineImg,position.x - 27 , pole / 46 * 12 + keyH , widthW / 13 , hidthH / 200);
        }
        if ((index == 3)||(index == 2)) {
            batch.draw(lineImg,position.x - 27 , pole / 46 * 12 + keyH , widthW / 13 , hidthH / 200);
            batch.draw(lineImg,position.x - 27 , pole / 46 * 8 + keyH , widthW / 13 , hidthH / 200);
        }
        if ((index== 1)||(index == 0)){
            batch.draw(lineImg,position.x - 27 , pole / 46 * 12 + keyH , widthW / 13 , hidthH / 200);
            batch.draw(lineImg,position.x - 27 , pole / 46 * 8 + keyH , widthW / 13 , hidthH / 200);
            batch.draw(lineImg,position.x - 27 , pole / 46 * 4 + keyH , widthW / 13 , hidthH / 200);
        }
        if( (index== 17)||(index==18)){
            batch.draw(lineImg,position.x - 27 , pole / 46 * 36 + keyH , widthW / 13 , hidthH / 200);
        }
        if ((index == 19)||(index==20)){
            batch.draw(lineImg,position.x - 27 , pole / 46 * 36 + keyH , widthW / 13 , hidthH / 200);
            batch.draw(lineImg,position.x - 27 , pole / 46 * 40 + keyH , widthW / 13 , hidthH / 200);
        }
        if ((index == 21)||(index==22)){
            batch.draw(lineImg,position.x - 27 , pole / 46 * 36 + keyH , widthW / 13 , hidthH / 200);
            batch.draw(lineImg,position.x - 27 , pole / 46 * 40 + keyH , widthW / 13 , hidthH / 200);
            batch.draw(lineImg,position.x - 27 , pole / 46 * 44 + keyH , widthW / 13 , hidthH / 200);
        }
        if (isSecond) {
            textureRegion = Assets.instance.note.note_greyGor;
            ran = 1;
            ranNote = 2;
        }
        if (ranNote == 1){
            TextureRegion reg = null;
            reg = (TextureRegion) noteAni.getKeyFrame(stateTime, true);
//            batch.draw(reg.getTexture(), position.x, position.y, 50, 34);
            batch.draw(reg.getTexture(),
                    position.x, position.y + 6,
                    origin.x, origin.y,
                    width, height,
                    scale.x, scale.y,
                    rotation,
                    reg.getRegionX(), reg.getRegionY(),
                    reg.getRegionWidth(), reg.getRegionHeight(),
                    false, false);
        }else {
            batch.draw(textureRegion, position.x , position.y + 6, width, height);
        }


        if (ran != 0) {

            Float center = width / 2 - noteSize / 2;
            font.draw(batch,noteName ,position.x + center ,position.y+53f);
//            font.draw(batch, note, position.x + 10, position.y + 50);
//            if (note.equals("Sol")) {
//                font.draw(batch, note, position.x + 8, position.y + 53);
////                label.setPosition(position.x + 15 , position.y + 55);
//            }else if(note.equals("Si")){
//                font.draw(batch, note, position.x + 25, position.y + 53);
//            }else if(note.equals("Do")){
//                font.draw(batch, note, position.x + 15, position.y + 53);
//            }else if(note.equals("Re")){
//                font.draw(batch, note, position.x + 15, position.y + 53);
////            }else if(note.equals("Fa")){
////                font.draw(batch, note, position.x + 28, position.y + 53);
//            }else {
//                font.draw(batch, note, position.x + 16, position.y + 53);
//            label.setPosition(position.x + 10 , position.y + 55);
//            }
        }
    }

    public int getNoteKey() {
        return noteKey;
    }
    private int ranNote(){
        ranNote = MathUtils.random(1, 4);

//        Random random = new Random();
//        ranNote = random.nextInt(1);
        return ranNote;
    }
    public NoteGoriz(DirectedGame directedGame , Stage stage , float widhtTop , float widthBot) {
        this.stage = stage;
        this.width = widthBot / 9.2f;
        this.height = widthBot / 13f;
        this.widhtTop = widhtTop;
        this.widthBot= widthBot ;
        this.game = directedGame;
        randomNote();
        nadpisOFF();
        if (ran==0){
            ranNote();
        }
        this.move= true;
//        ran = 0;
//        index = 22;
//        note ="Do";
//        noteNumber = 1;
        position = new Vector2(stage.getViewport().getWorldWidth(),((this.stage.getViewport().getWorldHeight() - this.stage.getViewport().getWorldHeight() / 4f - 50) / 23f) * index + this.stage.getViewport().getWorldHeight() / 4f);
//        position = new Vector2(770 , (index * 14) + 118);/////////////////////
        this.isSecond = false;
        dimension = new Vector2(1, 1);
        origin = new Vector2();
        scale = new Vector2(1, 1);
        rotation1 = 0;

        this.font = Assets.instance.fonts.defaultNormal;
//        font.setColor(0.11f,0.11f, 0.11f, 1);
        font.setColor(Color.valueOf("071d53"));
        noteName = Assets.languageNoteName(note);
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font, noteName);
        noteSize = glyphLayout.width;
    }
    private float nadpisOFF() {
        Random random = new Random();
        ran = random.nextInt(3);
        return ran;
    }
    public void setNoteCliked(boolean isSecond){
        this.isSecond = isSecond;
    }
    public boolean getNoteClicked(){
        return  isSecond;
    }
    public int getIndex(){
        return this.index;
    }
    public String getNote(){
        return note;
    }
    public Vector2 getPosition() {
        return position;
    }
    private float randomNote(){
        Random rand = new Random();
        index = rand.nextInt(22);

        if (( index==0)||(index==7)||(index==21)||(index==14)) {
            if (WorldController.getGameMode() == GameMode.BASS) {
                note = "Sol";
                noteKey =  5;
            } else {
                note = "Mi";
                noteKey =  3;
            }
//            System.out.println("Mi");
//            noteNumber = 2;
        }
        if (( index==1)||(index==8)||(index==22)||(index==15)) {
            if (WorldController.getGameMode() == GameMode.BASS) {
                note = "La";
                noteKey = 6;
            } else {
                note = "Fa";
                noteKey = 4;
            }
//            System.out.println("Fa");
//            noteNumber = 3;

        }
        if (( index==2)||(index==9)||(index==16)) {
            if(WorldController.getGameMode() == GameMode.BASS){
                note = "Si";
                noteKey = 7;
            }else {
                note = "Sol";
                noteKey = 5;
            }
//            System.out.println("Sol");
//            noteNumber = 4;

        }
        if (( index==3)||(index==10)||(index==17)) {
            if (WorldController.getGameMode() == GameMode.BASS) {
                note = "Do";
                noteKey = 1;
            } else {
                note = "La";
                noteKey = 6;
            }
//            System.out.println("La");
//            noteNumber = 5;

        }
        if (( index==4)||(index==11)||(index==18)) {
            if (WorldController.getGameMode() == GameMode.BASS) {
                note = "Re";
                noteKey = 2;
            } else {
                note = "Si";
                noteKey = 7;
//            System.out.println("si");
            }
//            System.out.println("Si");
//            noteNumber = 6;

        }
        if (( index==5)||(index==12)||(index==19)) {
            if (WorldController.getGameMode() == GameMode.BASS) {
                note = "Mi";
                noteKey = 3;
            } else {
                note = "Do";
                noteKey = 1;
            }
//            System.out.println("Do");
//            noteNumber = 0;
        }
        if (( index==6)||(index==13)||(index==20)) {
            if (WorldController.getGameMode() == GameMode.BASS) {
                note = "Fa";
                noteKey = 4;
            } else {
                note = "Re";
                noteKey = 2;
            }
//            System.out.println("Re");
//            noteNumber = 1;

        }
        return index;
    }

    public void act(float delta) {

        stateTime += Gdx.graphics.getDeltaTime();
        super.act(delta);
//        if  (GameManager.ourInstance.getGameState()== GameState.MOVE) {
            position.x -= 130 * delta;
//        }
        if (position.x <= 200){
            remove();
        }
    }
}
