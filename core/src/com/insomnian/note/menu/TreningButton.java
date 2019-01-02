package com.insomnian.note.menu;


import com.badlogic.gdx.math.Rectangle;
import com.insomnian.note.utils.Constants;

public class TreningButton extends GameButton {


    public interface TreningButtonListener {
         void onStart();
    }

    private TreningButtonListener listener;

    public TreningButton(Rectangle bounds, TreningButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    protected String getRegionName() {
        return Constants.TRENING_SCRIP_LEFT_REGION_NAME;
    }

    @Override
    public void touched() {
        listener.onStart();
    }
}
