package com.wj.mapper;

import com.wj.dto.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Project : wangjun
 * @Package : com.wj.mapper
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/1/13 22:10
 **/
@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {

}
