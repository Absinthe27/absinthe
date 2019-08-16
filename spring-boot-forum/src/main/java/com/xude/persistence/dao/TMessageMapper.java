package com.xude.persistence.dao;

import com.xude.persistence.model.TMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TMessageMapper {
    int insert(TMessage record);
    int updateOne(TMessage record);

    List<TMessage> selectAll();

}