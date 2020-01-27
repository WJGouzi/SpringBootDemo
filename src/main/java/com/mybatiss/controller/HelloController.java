package com.mybatiss.controller;

import com.utils.PostParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Project : wangjun
 * @Package : com.mybatis.controller
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/1/22 20:27
 **/

@RestController
@Slf4j
public class HelloController {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String helloToEverybody(String name) {
        return "hello to every body " + name;
    }

    @RequestMapping(value = "/hi/eachOther", method = RequestMethod.POST)
    public Map helloToEachOther(HttpServletRequest request) {
        String[] strings = {"name", "age"};
        Map map = PostParam.postParam(request, strings);
        return map;
    }

}


