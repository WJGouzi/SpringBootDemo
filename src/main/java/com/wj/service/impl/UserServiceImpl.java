package com.wj.service.impl;

import com.wj.dto.User;
import com.wj.mapper.UserMapper;
import com.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.persistence.Id;
import java.util.ArrayList;

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

    @Override
    public ArrayList<User> queryUserInfoByName(String name, Integer id) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", name);
        criteria.andEqualTo("id", id);
        ArrayList<User> users = (ArrayList<User>)userMapper.selectByExample(example);
        return users;
    }


}
