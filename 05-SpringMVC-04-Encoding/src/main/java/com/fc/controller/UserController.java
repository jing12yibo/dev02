package com.fc.controller;

import com.fc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("getObject")
public class UserController {
    @RequestMapping("user")
    public String getObject(User user) {
        System.out.println(user);

        return "/success.jsp";
    }
}
