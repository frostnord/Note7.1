package com.insomnian.note.utils;

import com.badlogic.gdx.math.MathUtils;

public  class LevelRandomizer {
    private int a = 0;
    private int b = 0;
    public int random ;

    /*
    -

    -

    -

    --
    */


    public int getRandom(int n) {

        switch (n){
            case 0:
                a = 5;
                b = 8;
                break;
            case 1:
                a = 1;
                b = 6;
                break;
            case 2:
                a = 1;
                b = 7;
                break;
            case 3:
                a = 1;
                b = 8;
                break;
        }
        random = MathUtils.random(a, b);

        return random;
    }
}
