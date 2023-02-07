package com.example.demo.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {


    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUser() {
        return userService.getUser();
    }
    @RequestMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("Something","Text");
        return "Welcome";
    }

    @PostMapping
    public void registerUser(@RequestBody User user){
        userService.addNewUser(user);
    }
}
