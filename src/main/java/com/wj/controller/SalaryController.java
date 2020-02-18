package com.wj.controller;

/**
 * @Project : wangjun
 * @Package : com.wj.controller
 * @Author : Created By gouzi, Copyright © gouzi All Rights Reserved
 * @Date : 2020/1/18
 */

import com.wj.dto.SalaryBean;
import com.wj.service.impl.SalaryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class SalaryController {
    @Autowired
    private SalaryServiceImpl salaryService;

    @RequestMapping(value = "/salary/insert")
    public Map insertSalaryInfo(@RequestBody SalaryBean salaryBean) {
        HashMap<Object, Object> map = new HashMap<>();
        try {
            salaryService.insertUserInfo(salaryBean);
            map.put("success", true);
            map.put("message", "插入薪水成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "插入信息失败");
        }
        return map;
    }

    @RequestMapping(value = "/salary/deleteWorker", method = RequestMethod.GET)
    public Map deletePersonWithWordID(String workID) {
        HashMap<Object, Object> map = new HashMap<>();
        try {
            salaryService.deleteWorker(workID);
            map.put("success", true);
            map.put("message", "删除员工" + workID + "成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "删除员工" + workID + "失败");
        }
        return map;
    }

}
