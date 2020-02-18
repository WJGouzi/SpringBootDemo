package com.wj.dto;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Project : wangjun
 * @Package : com.wj.dto
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/1/17 21:53
 **/

@Data
@Table(name = "exam")
public class ExamBean {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer flowId;
    private String name;
    private String idCard;
    private String testCard;
    private Integer examType;
    private String area;
    private Integer score;
}
