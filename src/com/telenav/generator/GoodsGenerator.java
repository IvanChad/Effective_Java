package com.telenav.generator;

/**
 * Created by yfchang on 6/1/2016.
 */
public class GoodsGenerator {
    private static GoodsGenerator INSTANCE = null;

    private GoodsGenerator() {
    }

    public static GoodsGenerator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GoodsGenerator();
        }
        return new GoodsGenerator();
    }
}
