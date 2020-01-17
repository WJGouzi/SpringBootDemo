package com.wj.service;

import com.wj.dto.ExamBean;

/**
 * @Project : wangjun
 * @Package : com.wj.service
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/1/17 21:57
 **/
public interface ExamService {

    /**
     * 插入考试的信息
     * @param examBean 考试实体类
     * @return
    */
    public int insertExamInfo(ExamBean examBean);

    /**
     * 通过身份证号码查询考试的成绩
     * @param idCard 身份证号码
     * @param testCard 考号
     * @return
     * */
    public ExamBean queryExamInfoWithIdCard(String idCard, String testCard);



}
