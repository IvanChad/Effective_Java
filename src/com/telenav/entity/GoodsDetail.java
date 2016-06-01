package com.telenav.entity;

/**
 * Created by yfchang on 6/1/2016.
 */
public class GoodsDetail {
    private final String name;
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;
    public static class Builder{
        private final String name;
        private int servingSize;
        private int servings;
        private int calories=0;
        private int fat=0;
        private int sodium=0;
        private int carbohydrate=0;
        public Builder(String name){
            this.name=name;
        }
        public Builder servingSize(int var1){
            servingSize=var1;
            return this;
        }
        public Builder servings(int var1){
            servings=var1;
            return this;
        }
        public Builder calories(int var1){
            calories=var1;
            return this;
        }
        public Builder fat(int var1){
            fat=var1;
            return this;
        }
        public Builder sodium(int var1){
            sodium=var1;
            return this;
        }
        public Builder carbohydrate(int var1){
            carbohydrate=var1;
            return this;
        }
        public GoodsDetail build(){
            return new GoodsDetail(this);
        }
    }
    private GoodsDetail(Builder builder){
        name=builder.name;
        servingSize=builder.servingSize;
        servings=builder.servings;
        calories=builder.calories;
        fat=builder.fat;
        sodium=builder.sodium;
        carbohydrate=builder.carbohydrate;
    }
    public String getName(){
        return name;
    }
    public int getServingSize(){
        return servingSize;
    }
    public int getServings(){
        return servings;
    }
    public int getCalories(){
        return calories;
    }
    public int getFat(){
        return fat;
    }
    public int getSodium(){
        return sodium;
    }
    public int getCarbohydrate(){
        return carbohydrate;
    }
    public String toString(){
        StringBuffer sb=new StringBuffer();
        sb.append(name+"\r\n");
        sb.append("servingSize  "+servingSize+"\r\n");
        sb.append("servings     "+servings+"\r\n");
        sb.append("calories     "+calories+"\r\n");
        sb.append("fat          "+fat+"\r\n");
        sb.append("sodium       "+sodium+"\r\n");
        sb.append("carbohydrate "+carbohydrate+"\r\n");
        return sb.toString();
    }
}
