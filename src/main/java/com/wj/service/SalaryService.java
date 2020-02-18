package com.wj.service;

import com.wj.dto.SalaryBean;

/**
 * @Project : wangjun
 * @Package : com.wj.service
 * @Author : Created By gouzi, Copyright © gouzi All Rights Reserved
 * @Date : 2020/1/18
 */
public interface SalaryService {

    /**
     * 插入员工的工资信息
     * @param salaryBean 员工的工资信息
     * */
    public int insertUserInfo(SalaryBean salaryBean);

    /**
     * 删除员工的信息
     * @param workerId 员工的工号
     * */
    public int deleteWorker(String workerId);
}
