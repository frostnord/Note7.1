package com.insomnian.note.utils;

import com.badlogic.gdx.utils.Array;

import java.util.Arrays;


public class Levels {

    static int[] l0;
    static int[] l1;

    public static int[][] ls;

    //    String lvl;
    static {
        int[] level0 =  {2, 5, 7, 8, 3, 0};
        l0 = level0;
        int[] level1 =  {5, 13, 9, 3,2, 5};
        l1 = level1;
        int[][] levels = {l0,l1};
        ls = levels;
    }




    public static int[] getLevel(int lvl) {
//        System.out.println(Arrays.deepToString(levels));
//        System.out.println(levels[lvl]);
//        System.out.println(Arrays.toString(ls[lvl]));
        return ls[lvl];
    }
}