package com.blueasdfg.analysis;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.blueasdfg.analysis.AnalysisApiUtil;


public class AnalysisResult {


     public static String result(String content) {

          //接收返回的结果
          String result = AnalysisApiUtil.getResult(content);
          result = result.substring(4, result.length() - 4);

          JSONArray jsonArray = JSONArray.fromObject(result);
          Object[] os = jsonArray.toArray();
          String response = "";
          for (int i = 0; i + 2 < os.length; i++) {
               JSONObject jsonObj1 = JSONObject.fromObject(os[i]);
               JSONObject jsonObj2 = JSONObject.fromObject(os[i + 1]);
               JSONObject jsonObj3 = JSONObject.fromObject(os[i + 2]);
               if (jsonObj1.get("pos").equals("v") && jsonObj1.get("cont").equals("喜欢")
                       && jsonObj2.get("pos").equals("v") && jsonObj2.get("cont").equals("吃")
                       && jsonObj3.get("pos").equals("n")) {
                    System.out.println(jsonObj3.get("cont"));
                    response = jsonObj3.get("cont").toString();
               }
          }

          //打印结果
          return response;


     }

}
