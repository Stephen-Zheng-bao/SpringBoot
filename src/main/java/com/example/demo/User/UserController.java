package com.example.demo.User;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }








    @GetMapping("/testGet")
    @ResponseBody
    public List<User> filterUser(@RequestParam String name){
    	return userService.fetchByName(name);
    }

    @PostMapping(value = "/add")
    public String createUser(@ModelAttribute User users, Model model, BindingResult bindingResult) {

    	System.out.println(users);
    	users.setRoles("USER");
        User user = userService.createUser(users);
        return "redirect:/index";
    }


    @RequestMapping(value = "/index")
    public String index(Model model) {
        /*        model.addAttribute("Something","Text");*/
        return "Welcome";
    }


    @GetMapping(value = "/index")
    public String get_Users(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        return "Welcome";}

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public String delete_User(@RequestParam String UserId) {
        userService.deleteUser(Integer.parseInt(UserId));
        return "redirect:/index";
    }


    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "Login/Signup";
    }

    @GetMapping("/forgot")
    public String forgot(Model model) {
        model.addAttribute("user", new User());
        return "Login/forgotpass";
    }

    @PostMapping("/addingUser")
    public String addingUser(@ModelAttribute User users, Model model, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        if (userService.checkEmailUnique(users.getEmail())){
            System.out.println(users);
            users.setRoles("USER");
            User user = userService.createUser(users);
            return "redirect:/login?success";
        }
        else {
            return "redirect:/register?error";
        }

    }




    }