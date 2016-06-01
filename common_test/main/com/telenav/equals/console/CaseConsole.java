package com.telenav.equals.console;

import com.telenav.equals.entity.CaseStringCompare;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yfchang on 6/1/2016.
 */
public class CaseConsole {
    public static void main(String[] args){
        CaseStringCompare caseStringCompare=new CaseStringCompare("Goods");
        String s="goods";
        List<CaseStringCompare> caseList=new ArrayList<CaseStringCompare>();
        caseList.add(caseStringCompare);
        System.out.println(caseList.contains(s));
        System.out.println(s.equals(caseStringCompare));
        System.out.println(caseStringCompare.equals(s));
    }
}
