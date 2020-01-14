package com.wj.service.impl;

import com.wj.dto.User;
import com.wj.mapper.UserMapper;
import com.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Project : wangjun
 * @Package : com.wj.service.impl
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/1/13 22:11
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUserInfo(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User queryUserInfoById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateUserBalance(Integer id, Double balance) {
        User user = this.queryUserInfoById(id);
        user.setCurrentBalance(balance);
        return userMapper.updateByPrimaryKey(user);
    }
}
