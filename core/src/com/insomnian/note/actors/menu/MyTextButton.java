package com.insomnian.note.actors.menu;

import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by 1 on 04.04.2017.
 */
public class MyTextButton extends TextButton {

    public MyTextButton(String text, TextButtonStyle style, EventListener listener) {
        super(text, style);
        addListener(listener);
    }
}