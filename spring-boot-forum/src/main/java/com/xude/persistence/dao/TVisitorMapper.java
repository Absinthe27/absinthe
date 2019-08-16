package com.xude.persistence.dao;

import com.xude.persistence.model.Post;
import com.xude.persistence.model.TVisitor;
import com.xude.persistence.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TVisitorMapper {
    int insert(TVisitor record);
    int updateNum(TVisitor record);
    TVisitor findVisitor(Post post, User user);
    List<TVisitor> selectAll();

}