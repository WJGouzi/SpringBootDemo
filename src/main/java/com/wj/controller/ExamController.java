package com.wj.controller;

import com.wj.dto.ExamBean;
import com.wj.service.ExamService;
import com.wj.service.impl.ExamServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
