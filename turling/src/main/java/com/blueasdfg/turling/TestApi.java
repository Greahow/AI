package com.blueasdfg.turling;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.blueasdfg.turling.TuLingApiUtil;


public class TestApi {

     public static String result(String content) {

          //接收返回的结果
          String result = TuLingApiUtil.getResult(content);

          //把json格式的字符串转化为json对象
          JsonObject json = new JsonParser().parse(result).getAsJsonObject();
          //获得text键的内容，并转化为string
          String back = json.get("text").toString();

          //打印结果
          return back;


     }

}
