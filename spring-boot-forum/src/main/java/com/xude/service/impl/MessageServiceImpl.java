package com.xude.service.impl;

import com.xude.persistence.dao.PostMapper;
import com.xude.persistence.dao.TMessageMapper;
import com.xude.persistence.model.TMessage;
import com.xude.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private TMessageMapper tMessageMapper;


    @Override
    public List<TMessage> getAll() {
        List<TMessage> tMessages = tMessageMapper.selectAll();
        return tMessages;
    }

    @Override
    public void saveMessge(TMessage tMessage) {
        tMessageMapper.insert(tMessage);
    }

    @Override
    public void updateMessge(TMessage tMessage) {
        tMessageMapper.updateOne(tMessage);
    }
}
