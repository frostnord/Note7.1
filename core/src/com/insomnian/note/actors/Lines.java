package com.insomnian.note.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.insomnian.note.Note;
import com.insomnian.note.game.Assets;

/**
 * Created by 1 on 18.01.2016.
 */
public class Lines extends Actor {

    public final Stage stage;
    public final Note game;
    private final int hidthH;
    private final float widthW;
    private final TextureRegion lineTextureRegion;
    private final TextureRegion triangleTextureRegion;

    public Lines(final Note game, Stage stage) {
        this.stage = stage;
        this.game = game;
        widthW = stage.getViewport().getWorldWidth();
        hidthH = (int) stage.getViewport().getWorldHeight();
        lineTextureRegion = Assets.instance.decoration.lineImg;
        triangleTextureRegion = Assets.instance.decoration.triangleImgRot;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        float lineW = widthW / 100 ;
        float lineH = (hidthH - (hidthH / 4f)-50) / 46;
        float pole = hidthH - hidthH / 4 - 50;

//        batch.draw(lineTextureRegion, widthW / 23, (lineH * 0) + (hidthH / 4f), widthW, hidthH / 200);

        batch.draw(lineTextureRegion, widthW / 23, (lineH * 16) + (hidthH / 4f), widthW, hidthH / 200);
        batch.draw(lineTextureRegion, widthW / 23, (lineH * 20) + (hidthH / 4f), widthW, hidthH / 200);
        batch.draw(lineTextureRegion, widthW / 23, (lineH * 24) + (hidthH / 4f), widthW, hidthH / 200);
        batch.draw(lineTextureRegion, widthW / 23, (lineH * 28) + (hidthH / 4f), widthW, hidthH / 200);
        batch.draw(lineTextureRegion, widthW / 23, (lineH * 32) + (hidthH / 4f), widthW, hidthH / 200);

            batch.draw(triangleTextureRegion, widthW - lineW, (pole / 46 )* 3 + hidthH / 4 , widthW / 100, (hidthH - (hidthH / 4f)) / 23 );
            batch.draw(triangleTextureRegion, widthW - lineW, (pole / 46 )* 7 + hidthH / 4 , widthW / 100, (hidthH - (hidthH / 4f)) / 23 );
            batch.draw(triangleTextureRegion, widthW - lineW, (pole / 46 )* 11 + hidthH / 4 , widthW / 100, (hidthH - (hidthH / 4f)) / 23 );
            batch.draw(triangleTextureRegion, widthW - lineW, (pole / 46 )* 15 + hidthH / 4 , widthW / 100, (hidthH - (hidthH / 4f)) / 23 );
            batch.draw(triangleTextureRegion, widthW - lineW, (pole / 46 )* 19 + hidthH / 4 , widthW / 100, (hidthH - (hidthH / 4f)) / 23 );
            batch.draw(triangleTextureRegion, widthW - lineW, (pole / 46 )* 23 + hidthH / 4 , widthW / 100, (hidthH - (hidthH / 4f)) / 23 );
            batch.draw(triangleTextureRegion, widthW - lineW, (pole / 46 )* 27 + hidthH / 4 , widthW / 100, (hidthH - (hidthH / 4f)) / 23 );
            batch.draw(triangleTextureRegion, widthW - lineW, (pole / 46 )* 31 + hidthH / 4 , widthW / 100, (hidthH - (hidthH / 4f)) / 23 );
            batch.draw(triangleTextureRegion, widthW - lineW, (pole / 46 )* 35 + hidthH / 4 , widthW / 100, (hidthH - (hidthH / 4f)) / 23 );
            batch.draw(triangleTextureRegion, widthW - lineW, (pole / 46 )* 39 + hidthH / 4 , widthW / 100, (hidthH - (hidthH / 4f)) / 23 );
            batch.draw(triangleTextureRegion, widthW - lineW, (pole / 46 )* 43 + hidthH / 4 , widthW / 100, (hidthH - (hidthH / 4f)) / 23 );



//            batch.draw(triangleTextureRegion, widthW - lineW, (lineH * 3) + (hidthH / 4f)- (hidthH - (hidthH / 4f)) / 23 / 2 , widthW / 100, (hidthH - (hidthH / 4f)) / 23);
//            batch.draw(triangleTextureRegion, widthW - lineW, (lineH * 7) + (hidthH / 4f)- (hidthH - (hidthH / 4f)) / 23 / 2 , widthW / 100, (hidthH - (hidthH / 4f)) / 23);
//            batch.draw(triangleTextureRegion, widthW - lineW, (lineH * 11) + (hidthH / 4f)- (hidthH - (hidthH / 4f)) / 23 / 2 , widthW / 100, (hidthH - (hidthH / 4f)) / 23);
//            batch.draw(triangleTextureRegion, widthW - lineW, (lineH * 15) + (hidthH / 4f)- (hidthH - (hidthH / 4f)) / 23 / 2 , widthW / 100, (hidthH - (hidthH / 4f)) / 23);
//            batch.draw(triangleTextureRegion, widthW - lineW, (lineH * 19) + (hidthH / 4f)- (hidthH - (hidthH / 4f)) / 23 / 2 , widthW / 100, (hidthH - (hidthH / 4f)) / 23);
//            batch.draw(triangleTextureRegion, widthW - lineW, (lineH * 23) + (hidthH / 4f)- (hidthH - (hidthH / 4f)) / 23 / 2 , widthW / 100, (hidthH - (hidthH / 4f)) / 23);
//            batch.draw(triangleTextureRegion, widthW - lineW, (lineH * 27) + (hidthH / 4f)- (hidthH - (hidthH / 4f)) / 23 / 2 , widthW / 100, (hidthH - (hidthH / 4f)) / 23);
//            batch.draw(triangleTextureRegion, widthW - lineW, (lineH * 31) + (hidthH / 4f)- (hidthH - (hidthH / 4f)) / 23 / 2 , widthW / 100, (hidthH - (hidthH / 4f)) / 23);
//            batch.draw(triangleTextureRegion, widthW - lineW, (lineH * 35) + (hidthH / 4f)- (hidthH - (hidthH / 4f)) / 23 / 2 , widthW / 100, (hidthH - (hidthH / 4f)) / 23);
//            batch.draw(triangleTextureRegion, widthW - lineW, (lineH * 39) + (hidthH / 4f)- (hidthH - (hidthH / 4f)) / 23 / 2 , widthW / 100, (hidthH - (hidthH / 4f)) / 23);
//            batch.draw(triangleTextureRegion, widthW - lineW, (lineH * 43) + (hidthH / 4f)- (hidthH - (hidthH / 4f)) / 23 / 2 , widthW / 100, (hidthH - (hidthH / 4f)) / 23);
//            i++;
//            i++;
//            i++;
//        }
//        batch.draw(triangleTextureRegion, widthW - lineW, (lineH * 0) + (hidthH / 4f) - lineH / 2 + 2, widthW / 100, (hidthH - (hidthH / 4f)) / 23);
    }
}
