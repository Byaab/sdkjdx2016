package com.isoft.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserAction {
    @RequestMapping("/login.do")
    @ResponseBody
    public String login(String uname, String upwd) {
        /*硬编码*/
        if (uname.equals("admin") && upwd.equals("123456"))
            return "success";
        else
            return "fault";
    }    @RequestMapping("/register.do")
    @ResponseBody
    public String login(String uname, String upwd,String email) {
        /*硬编码*/
        System.out.printf(email);
        boolean temp = true;
        if (temp)
            return "success";
        else
            return "fault";
    }
}
