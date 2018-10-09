package com.blueasdfg.analysis;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 词法分析api工具类
 */


public class AnalysisApiUtil {

     //自己的apikey，注意不是密钥
     private static final String key = "your key";
     private static final String pattern = "pos";
     private static final String format = "json";

     public static String getResult(String text) {

          //词法分析api接口
          String apiUrl = "https://api.ltp-cloud.com/analysis/?api_key=" + key + "&text=" + text + "&pattern=" + pattern + "&format=" + format;

          try {
               //内容需要utf-8编码(官方文档中有说明)
               text = URLEncoder.encode(text, "utf-8");
               //拼接url
               apiUrl = "https://api.ltp-cloud.com/analysis/?api_key=" + key + "&text=" + text + "&pattern=" + pattern + "&format=" + format;

          } catch (UnsupportedEncodingException e) {

               e.printStackTrace();

          }

          //封装请求头
          HttpGet request = new HttpGet(apiUrl);

          String result = "";

          try {
               //发送http请求
               HttpResponse response = HttpClients.createDefault().execute(request);

               //获取响应码
               int code = response.getStatusLine().getStatusCode();

               if (code == 200) {
                    //获取返回的结果
                    result = EntityUtils.toString(response.getEntity());
               } else {
                    System.out.println("code=" + code);
               }

          } catch (ClientProtocolException e) {
               e.printStackTrace();
          } catch (IOException e) {
               e.printStackTrace();
          }

          //返回结果
          return result;
     }


}
