package com.fc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//将当前类注入到容器中
@Controller
//用于声明请求的url路径，和@webservlet相同
@RequestMapping("user")
public class UserController {
    @RequestMapping("login")
    public String login() {
        System.out.println("login");

        return "/login.jsp";
    }


    @RequestMapping("add")
    public String add() {
        System.out.println("add");

        return "/success.jsp";
    }

    //方法上也能加RequestMapping注解，相当于二级路径
    @RequestMapping("update")
    public String update() {
        System.out.println("update");

        //指定页面跳转的路径，注意加/代表从根路径开始
        return "/success.jsp";
    }

}
