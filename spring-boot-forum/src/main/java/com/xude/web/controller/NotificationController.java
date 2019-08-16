package com.xude.web.controller;

import com.xude.exception.ResourceNotFoundException;
import com.xude.persistence.model.TMessage;
import com.xude.service.MessageService;
import com.xude.service.PostService;
import com.xude.service.UserService;
import com.xude.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class NotificationController {

    private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);
    @Resource
    private RedisUtil redisUtil;
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/notification/redirect", method = RequestMethod.GET)
    public String index(Model model) {
//
        String natifNum = redisUtil.getNatifNum(userService.findAuthenticatedUser().getId());

        if (natifNum == null || natifNum.equals(null)) {
            natifNum = "null";
        }
        redisUtil.delNatifNum(userService.findAuthenticatedUser().getId());

//        model.addAttribute(attributes);
//        return "forum/user-notification";


        Map<String, Object> attributes = postService.findPostsOrderByCommontDate();
        if (null == attributes) {
            throw new ResourceNotFoundException("attributes not found.");
        }


        attributes.put("natifNum",natifNum);
        model.addAllAttributes(attributes);
        return "forum/user-notification";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/notification/getNum", method = RequestMethod.GET)
    @ResponseBody
    public String getNum(Model model) {
        String natifNum = redisUtil.getNatifNum(userService.findAuthenticatedUser().getId());
        if (natifNum == null || natifNum.equals(null)) {
            return "";
        } else {
            return natifNum;
        }
    }
}