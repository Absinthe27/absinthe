package com.xude.service;

import com.xude.persistence.model.Post;
import com.xude.persistence.model.TMessage;
import com.xude.persistence.model.TVisitor;
import com.xude.persistence.model.User;

import java.util.List;

public interface VisitorService {

    TVisitor findVisitor(Post post, User user);
    int insert(TVisitor record);
    void updateNum(TVisitor record);

}
