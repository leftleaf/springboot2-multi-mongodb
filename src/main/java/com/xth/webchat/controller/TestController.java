package com.xth.webchat.controller;

import com.xth.webchat.dao.MessageRepository;
import com.xth.webchat.dao.UserRepository;
import com.xth.webchat.entity.Message;
import com.xth.webchat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/user")
    @ResponseBody
    public void test() {
        userRepository.save(new User("1", "xth", "abc", "haha"));
    }
}
