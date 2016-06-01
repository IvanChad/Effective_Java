package com.telenav.Console;

import com.telenav.parse.GoodsObjectUtil;

/**
 * Created by yfchang on 6/1/2016.
 */
public class CaseObjectConsole {
    public static void main(String[] args){
        System.out.println(GoodsObjectUtil.getGoodsMap("resource/goods_list_item.xml"));
    }
}
