package com.wj.service.impl;

import com.wj.dto.SalaryBean;
import com.wj.mapper.SalaryMapper;
import com.wj.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Project : wangjun
 * @Package : com.wj.service.impl
 * @Author : Created By gouzi, Copyright © gouzi All Rights Reserved
 * @Date : 2020/1/18
 */
@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryMapper salaryMapper;

    @Override
    public int insertUserInfo(SalaryBean salaryBean) {
        return salaryMapper.insert(salaryBean);
    }

    @Override
    public int deleteWorker(String workerId) {
        return salaryMapper.deleteWorkerWithID(workerId);
    }
}
