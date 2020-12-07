package com.tivnan.studentls.dao;

import com.tivnan.studentls.bean.Times;
import com.tivnan.studentls.bean.TimesExample;
import com.tivnan.studentls.bean.TimesKey;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TimesMapper {
    long countByExample(TimesExample example);

    int deleteByExample(TimesExample example);

    int deleteByPrimaryKey(TimesKey key);

    int insert(Times record);

    int insertSelective(Times record);

    List<Times> selectByExample(TimesExample example);

    Integer selectByExampleWithTimesId(TimesExample example);

    Times selectByPrimaryKey(TimesKey key);

    int updateByExampleSelective(@Param("record") Times record, @Param("example") TimesExample example);

    int updateByExample(@Param("record") Times record, @Param("example") TimesExample example);

    int updateByPrimaryKeySelective(Times record);

    int updateByPrimaryKey(Times record);


}