package com.telenav.parse;

import com.telenav.Commons.AssistUtil;
import com.telenav.entity.GoodsDetail;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yfchang on 6/1/2016.
 */
public class GoodsObjectUtil {
    private static SAXParserFactory saxParserFactory;
    static{
        saxParserFactory=SAXParserFactory.newInstance();
    }
    public static Map<String,List<GoodsDetail>> getGoodsMap(String filePath){
        Map<String,List<GoodsDetail>> goodsMap=null;
        if(AssistUtil.judgeFilePathExixt(filePath)){
            SAXParser saxParser;
            try {
                saxParser=saxParserFactory.newSAXParser();
                GoodsHandle goodsHandle=new GoodsHandle();
                saxParser.parse(new File(filePath),goodsHandle);
                goodsMap=goodsHandle.getGoodsDetailTypeMap();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return goodsMap;
    }
}
