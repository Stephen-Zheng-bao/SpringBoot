package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// This controller can be deleted and moved
@Controller
public class LoginController

{
    @Autowired
    public LoginController(){

    }
    @GetMapping("/login")
    public String login(){
        return "Login/Login";
    }
}
