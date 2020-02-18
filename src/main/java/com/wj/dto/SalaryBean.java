package com.wj.dto;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Project : wangjun
 * @Package : com.wj.dto
 * @Author : Created By gouzi, Copyright © gouzi All Rights Reserved
 * @Date : 2020/1/18
 */

@Data
@Table(name = "t_salary")
public class SalaryBean {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private Integer workId;
    private String name;
    private String title;
    private Float salary;
}
