package com.xude.service.impl;

import com.xude.persistence.dao.TMessageMapper;
import com.xude.persistence.dao.TVisitorMapper;
import com.xude.persistence.model.Post;
import com.xude.persistence.model.TMessage;
import com.xude.persistence.model.TVisitor;
import com.xude.persistence.model.User;
import com.xude.service.MessageService;
import com.xude.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("VisitorService")
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private TVisitorMapper tVisitorMapper;

    @Override
    public TVisitor findVisitor(Post post, User user) {
        TVisitor visitor = tVisitorMapper.findVisitor(post, user);
        return visitor;
    }

    @Override
    public int insert(TVisitor record) {

        return   tVisitorMapper.insert(record);
    }

    @Override
    public void updateNum(TVisitor record) {
         tVisitorMapper.updateNum(record);
     ;
    }
}
