package com.mrc.bootproject.mapper;

import com.mrc.bootproject.domain.A;
import com.mrc.bootproject.domain.AExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface AMapper {
    long countByExample(AExample example);

    int deleteByExample(AExample example);

    int deleteByPrimaryKey(Long id);

    int insert(A record);

    int insertSelective(A record);

    List<A> selectByExample(AExample example);

    A selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") A record, @Param("example") AExample example);

    int updateByExample(@Param("record") A record, @Param("example") AExample example);

    int updateByPrimaryKeySelective(A record);

    int updateByPrimaryKey(A record);

    int updateBatch(List<A> list);

    int updateBatchSelective(List<A> list);

    int batchInsert(@Param("list") List<A> list);
}