package com.insomnian.note.utils;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.kotcrab.vis.ui.VisUI;


public class MyTexturePacker {

    public static void main(String[] args) {
        TexturePacker.Settings settings = new TexturePacker.Settings();

        settings.maxWidth= 2048;
        settings.maxHeight= 2048;
        settings.paddingX=2;
        settings.paddingY=2;
        settings.debug=false;
        TexturePacker.process(settings,"\\Users\\1\\Desktop\\assets", "\\Projects\\Note\\note7\\android\\assets", "sprites");
        TexturePacker.process(settings,"\\Users\\1\\Desktop\\ui","\\Projects\\Note\\note7\\android\\assets", "ui");
    }
}