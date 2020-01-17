package com.wj.service.impl;

import com.wj.dto.ExamBean;
import com.wj.mapper.ExamMapper;
import com.wj.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Project : wangjun
 * @Package : com.wj.service.impl
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/1/17 22:04
 **/
@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamMapper examMapper;

    @Override
    public int insertExamInfo(ExamBean examBean) {
        return examMapper.insert(examBean);
    }

    @Override
    public ExamBean queryExamInfoWithIdCard(String idCard, String testCard) {

        //return examMapper.findStudentExamInfo(idCard, testCard);

        Example example = new Example(ExamBean.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("idCard", idCard);
        criteria.andEqualTo("testCard", testCard);
        List<ExamBean> list = examMapper.selectByExample(example);
        return list.get(0);
    }

}
