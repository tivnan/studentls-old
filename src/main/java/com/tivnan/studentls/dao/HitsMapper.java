package com.tivnan.studentls.dao;

import com.tivnan.studentls.bean.HitsExample;
import com.tivnan.studentls.bean.HitsKey;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface HitsMapper {
    long countByExample(HitsExample example);

    int deleteByExample(HitsExample example);

    int deleteByPrimaryKey(HitsKey key);

    int insert(HitsKey record);

    int insertSelective(HitsKey record);

    List<HitsKey> selectByExample(HitsExample example);

    int updateByExampleSelective(@Param("record") HitsKey record, @Param("example") HitsExample example);

    int updateByExample(@Param("record") HitsKey record, @Param("example") HitsExample example);
}