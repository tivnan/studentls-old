package com.tivnan.studentls.dao;

import com.tivnan.studentls.bean.TakesExample;
import com.tivnan.studentls.bean.TakesKey;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TakesMapper {
    long countByExample(TakesExample example);

    int deleteByExample(TakesExample example);

    int deleteByPrimaryKey(TakesKey key);

    int insert(TakesKey record);

    int insertSelective(TakesKey record);

    List<TakesKey> selectByExample(TakesExample example);

    int updateByExampleSelective(@Param("record") TakesKey record, @Param("example") TakesExample example);

    int updateByExample(@Param("record") TakesKey record, @Param("example") TakesExample example);
}