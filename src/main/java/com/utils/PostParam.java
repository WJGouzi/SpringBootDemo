package com.utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @Project : wangjun
 * @Package : com.utils
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/1/27 17:04
 **/

public class PostParam {
    public static Map postParam(HttpServletRequest req, String ...args) {
        HashMap<Object, Object> map = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String s = null;
            while((s = br.readLine()) != null){
                sb.append(s);
            }
            JSONObject jsonObject = JSONObject.parseObject(sb.toString());
            for (String arg : args) {
                String argValue = jsonObject.getString(arg);
                map.put(arg, argValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}
