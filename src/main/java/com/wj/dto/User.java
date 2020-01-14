package com.wj.dto;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Project : wangjun
 * @Package : com.wj.dto
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/1/13 22:09
 **/

@Data
@Table(name = "user_info")
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String name;
    private Integer age;
    private Integer gender;
    private Double height;
    private Double currentBalance;
}
