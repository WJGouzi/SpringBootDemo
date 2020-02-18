package com.wj.controller;

import com.alibaba.fastjson.JSONObject;
import com.wj.dto.ExamBean;
import com.wj.dto.User;
import com.alibaba.fastjson.JSONObject;
import com.wj.service.impl.ExamServiceImpl;
import com.wj.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Project : wangjun
 * @Package : com.wj.controller
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/1/17 22:17
 **/
@RestController
@Slf4j
public class ExamController {

    @Autowired
    private ExamServiceImpl examService;
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/exam/insert", method = RequestMethod.POST)
    public Map insertOneExamInfo(@RequestBody ExamBean examBean) {
        HashMap<Object,Object> map = new HashMap<Object,Object>();
        try {
            examService.insertExamInfo(examBean);
            map.put("message", "添加成功");
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message", "添加失败");
            map.put("success", false);
        }
        return map;
    }

    @RequestMapping(value = "/exam/queryInfo", method = RequestMethod.POST)
    public Map findStudentExamInfo(@RequestBody ExamBean examBean) {
        HashMap<Object, Object> map = new HashMap<>();
        try {
            ExamBean examBeanInfo = examService.queryExamInfoWithIdCard(examBean.getIdCard(), examBean.getTestCard());
            map.put("success", true);
            map.put("message", "查询成功!");
            map.put("info", examBeanInfo);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "查询失败!");
            map.put("info", null);
        }
        return map;
    }

    @RequestMapping(value = "/exam/newStudent", method = RequestMethod.POST)
    public Map newStudentJoinExam(@RequestBody User user) {
        HashMap<Object, Object> map = new HashMap<>();
        ArrayList<User> users = userService.queryUserInfoByName(user.getName(), user.getId());
        try {
            for (User userBean : users) {
                ExamBean examBean = new ExamBean();
                examBean.setName(userBean.getName());
                examService.insertExamInfo(examBean);
            }
            map.put("success", true);
            map.put("message", "报名成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "报名失败");
        }
        return map;
    }

    @RequestMapping(value = "/exam/updateStudentScoreInfo", method = RequestMethod.POST)
    public Map modifyStudentScoreInfo(HttpServletRequest req) {
        HashMap<Object, Object> map = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String s = null;
            while((s = br.readLine()) != null){
                sb.append(s);
            }
            JSONObject jsonObject = JSONObject.parseObject(sb.toString());
            String idCard = jsonObject.getString("idCard");
            String score = jsonObject.getString("score");
            examService.updateExamScoreWithIdCard(idCard, score);
            map.put("success", true);
            map.put("message", "成绩设置成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "成绩设置失败");
        }
        return map;
    }
}
