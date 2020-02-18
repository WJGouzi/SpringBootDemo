package com.wj.mapper;

import com.wj.dto.SalaryBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Project : wangjun
 * @Package : com.wj.mapper
 * @Author : Created By gouzi, Copyright © gouzi All Rights Reserved
 * @Date : 2020/1/18
 */
@Mapper
public interface SalaryMapper extends tk.mybatis.mapper.common.Mapper<SalaryBean> {

    @Delete("delete from t_salary where work_id = #{workId}")
    int deleteWorkerWithID(@Param("workId") String workId);
}
