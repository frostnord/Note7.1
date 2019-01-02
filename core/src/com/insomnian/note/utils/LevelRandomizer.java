package com.insomnian.note.utils;

import com.badlogic.gdx.math.MathUtils;

public  class LevelRandomizer {
    private int a = 0;
    private int b = 0;
    private int random ;

    /*
    0 самая нижняя нота

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
                a = 5;
                b = 10;
                break;
            case 2:
                a = 5;
                b = 12;
                break;
            case 3:
                a = 5;
                b = 13;
                break;
            case 4:
                a = 5;
                b = 15;
                break;

            case 5:
                a = 15;
                b = 18;
                break;
            case 6:
                a = 15;
                b = 22;
                break;
            case 7:
                a = 5;
                b = 22;
                break;
            case 8:
                a = 2;
                b = 5;
                break;
            case 9:
                a = 0;
                b = 5;
                break;
            case 10:
                a = 2;
                b = 19;
                break;
            case 11:
                a = 0;
                b = 22;
                break;


        }
        random = MathUtils.random(a, b);

        return random;
    }
}
