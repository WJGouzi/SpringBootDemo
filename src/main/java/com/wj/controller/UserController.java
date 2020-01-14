package com.wj.controller;

import com.wj.dto.User;
import com.wj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Project : wangjun
 * @Package : com.wj.controller
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/1/13 22:08
 **/

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/insert")
    public Map insert(@RequestBody User user){
        HashMap<Object,Object> map = new HashMap<Object,Object>();
        try {
            userService.insertUserInfo(user);
            map.put("success",true);
            map.put("message","数据插入成功！");
            log.debug("数据插入成功");
            return map;
        }catch (Exception e){
            e.printStackTrace();
            log.debug("数据插入失败！");
            map.put("success",false);
            map.put("message","数据插入失败");
            return map;
        }
    }

    @RequestMapping(value = "/api/query")
    public Map queryById(@RequestBody User user){
        HashMap<Object,Object> map = new HashMap<Object,Object>();
        try {
            User userInfo = userService.queryUserInfoById(user.getId());
            log.debug("数据查询成功！");
            map.put("success",true);
            map.put("message","数据查询成功！");
            map.put("result",userInfo);
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("message","数据查询失败！");
            log.debug("数据查询失败！");
            return map;
        }
    }

    @RequestMapping(value = "wj/modify")
    public Map update(@RequestBody User user) {
        HashMap<Object, Object> map = new HashMap<>();
        try {
            userService.updateUserBalance(user.getId(), user.getCurrentBalance());
            log.debug("数据修改成功");
            map.put("success", true);
            map.put("message", "数据修改成功!");
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("数据修改失败");
            map.put("success", false);
            map.put("message", "数据修改失败!");
        }
        return map;
    }

}
