package com.turing.sb6.controller;

import com.turing.sb6.entity.User;
import com.turing.sb6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService us;

    @PostMapping("/login")
    public String login(User user, HttpSession session){
        User user1 = us.loginUser(user);
        if(user1!=null){
          session.setAttribute("userl",user1);
          return "redirect:/user/index";
        }else{
          return "redirect:/user/";
        }
    }

    @PostMapping("/login2")
    @ResponseBody
    public String login2(User user, HttpSession session){
        User user1 = us.loginUser(user);
        if(user1!=null){
            session.setAttribute("userl",user1);
            return "success";
        }else{
            return "noSuccess";
        }
    }
}
