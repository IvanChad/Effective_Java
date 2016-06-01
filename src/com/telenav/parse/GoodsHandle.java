package com.telenav.parse;

import com.telenav.entity.GoodsDetail;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yfchang on 6/1/2016.
 */
public class GoodsHandle extends DefaultHandler {
    private GoodsDetail goodsDetail;
    private GoodsDetail.Builder builder;
    private Map<String, List<GoodsDetail>> goodsDetailTypeMap;
    private List<GoodsDetail> goodsDetailList;
    private String goodsTypeName;

    public void startDocument() throws SAXException {
        super.startDocument();
    }

    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) {
        Method method=null;
        if (qName.equalsIgnoreCase("GoodsList")) {
            goodsDetailTypeMap = new HashMap<String, List<GoodsDetail>>();
        } else if (qName.equalsIgnoreCase("GoodsType")) {
            goodsTypeName = attributes.getValue("name");
            goodsDetailList = new ArrayList<GoodsDetail>();
        } else if (qName.equalsIgnoreCase("Goods")) {
            String name = attributes.getValue("name");
            if (name != null && !name.isEmpty()) {
                builder = new GoodsDetail.Builder(name);
            }
        } else if (qName.equalsIgnoreCase("item")) {
            String methodName = attributes.getValue("name");
            String methodParam = attributes.getValue("value");
            try {
                if (!methodName.isEmpty()) {
                    method = builder.getClass().getMethod(methodName, int.class);
                }
                if(methodParam!=null && !methodParam.isEmpty()){
                    int var=Integer.parseInt(methodParam);
                    method.invoke(builder,var);
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    public void endElement(String uri, String localName, String qName){
        if(qName.equalsIgnoreCase("Goods")){
            if(builder!=null){
                goodsDetail=builder.build();
                goodsDetailList.add(goodsDetail);
            }
        }else if(qName.equalsIgnoreCase("GoodsType")){
            goodsDetailTypeMap.put(goodsTypeName,goodsDetailList);
        }
    }
    public Map<String,List<GoodsDetail>> getGoodsDetailTypeMap(){
        return goodsDetailTypeMap;
    }
}
