package com.wj.mapper;

import com.wj.dto.ExamBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Project : wangjun
 * @Package : com.wj.mapper
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/1/17 22:05
 **/
@Mapper
public interface ExamMapper extends tk.mybatis.mapper.common.Mapper<ExamBean> {
    @Select("select * from exam where id_card = #{idCard} and test_card = #{testCard}")
    ExamBean findStudentExamInfo(@Param("idCard") String idCard, @Param("testCard") String testCard);
}
