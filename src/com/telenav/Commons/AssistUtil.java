package com.telenav.Commons;

import java.io.File;

/**
 * Created by yfchang on 6/1/2016.
 */
public class AssistUtil {
    public static boolean judgeFilePathExixt(String filePath){
        boolean flag;
        File file=new File(filePath);
        if(file.exists() && file.isFile() && file.getAbsolutePath().endsWith("xml")){
            flag=true;
        }else{
            flag=false;
        }
        return flag;
    }
}
