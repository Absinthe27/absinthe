package com.xude.web.controller;

import com.xude.exception.BadRequestException;
import com.xude.exception.ResourceNotFoundException;
import com.xude.persistence.model.Category;
import com.xude.persistence.model.Comment;
import com.xude.persistence.model.Post;
import com.xude.persistence.model.TMessage;
import com.xude.service.*;
import com.xude.util.NewPostFormValidator;
import com.xude.web.dto.CommentDto;
import com.xude.web.dto.PostDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
public class MessageController {

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;


    @RequestMapping(value = "/message/getOne", method = RequestMethod.GET)
    @ResponseBody
    public TMessage getOne(Model model) {

        List<TMessage> all = messageService.getAll();
        Random ran = new Random();
        int i = ran.nextInt(all.size());
        return all.get(i);
    }

    @RequestMapping(value = "/message/add", method = RequestMethod.GET)
    public String addMessage(Model model) {
        List<TMessage> all = messageService.getAll();
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("messges", all);
        model.addAllAttributes(attributes);
        return "forum/messageEdit";
    }

    @RequestMapping(value = "/message/add", method = RequestMethod.POST)
    public String addMessageSave(Model model, @Valid @ModelAttribute TMessage tMessage) {
        messageService.saveMessge(tMessage);

        return "redirect:/";
    }



}