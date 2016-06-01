package com.telenav.equals.entity;

/**
 * Created by yfchang on 6/1/2016.
 */
public class CaseStringCompare {
    private String s;
    public CaseStringCompare(String v){
        if(v!=null){
            s=v;
        }
    }
    public boolean equals(Object o){
        if(o instanceof CaseStringCompare){
            return s.equalsIgnoreCase(((CaseStringCompare)o).s);
        }
        if(o instanceof String){
            return s.equalsIgnoreCase((String)o);
        }
        return false;
    }
}
