package com.wj.service;

import com.wj.dto.User;

import java.util.ArrayList;

/**
 * @Project : wangjun
 * @Package : com.wj.service
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/1/13 22:11
 **/
public interface UserService {
    /**
     * 插入用户信息
     * @param user
     * @return
     */
    public int insertUserInfo(User user);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    public User queryUserInfoById(Integer id);
    
    /**
     * 修改用户的余额
     * @param id
     * @param balance
     * @return
     * */
    public int updateUserBalance(Integer id, Double balance);

    /**
     * 根据用户的姓名查询用户的信息
     * @param name 用户的姓名
     * */
    public ArrayList<User> queryUserInfoByName(String name, Integer id);

}
