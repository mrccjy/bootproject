package com.mrc.bootproject.mapper;

import com.mrc.bootproject.domain.B;
import com.mrc.bootproject.domain.BExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface BMapper {
    long countByExample(BExample example);

    int deleteByExample(BExample example);

    int deleteByPrimaryKey(Long id);

    int insert(B record);

    int insertSelective(B record);

    List<B> selectByExample(BExample example);

    B selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") B record, @Param("example") BExample example);

    int updateByExample(@Param("record") B record, @Param("example") BExample example);

    int updateByPrimaryKeySelective(B record);

    int updateByPrimaryKey(B record);

    int updateBatch(List<B> list);

    int updateBatchSelective(List<B> list);

    int batchInsert(@Param("list") List<B> list);
}