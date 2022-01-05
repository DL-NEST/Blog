package com.link.blog.util;


import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * @author dl-nest
 * @apiNote 对字符串的处理类
 * @date 2022/1/6 18:52
 */
public class StrUtil {
    // 字符串的拼接方法
    public static String strForm(int uid, String mac, String ip){
        return uid+";"+mac+";"+ip+";";
    }

    public static String[] parsForm(String str){
        String[] strList = new String[3];
        StringBuilder value = new StringBuilder();
        int ii = 0;
        for (int i = 0; i<str.length();i++)
        {
            if (str.charAt(i) == ';'){
                strList[ii] = value.toString();
                value = new StringBuilder();
                ii++;
                if(ii != 3){
                    i++;
                }
            }
            value.append(str.charAt(i));
        }
//        System.out.println(Arrays.toString(strList));
        return strList;
    }

    public static String parsForm(String str,int index){
        return parsForm(str)[index];
    }

    public static JSONObject parsJson(String str){
        String[] List = parsForm(str);
        JSONObject re = new JSONObject();
        re.put("Uid",List[0]);
        re.put("Mac",List[1]);
        re.put("Ip",List[2]);
        return re;
    }

}
