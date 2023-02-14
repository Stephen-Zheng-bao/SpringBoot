package com.example.demo.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

/*   @RequestMapping(value = "/welcome")
    public List<User> getUser() {
        return userService.getUser();
    }*/


    @RequestMapping(value = "/index")
    public String index(Model model) {
        /*        model.addAttribute("Something","Text");*/
        return "Welcome";
    }


    @GetMapping(value = "/index")
    public String getUsers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("user", new User());
        return "Welcome";
    }

    @PostMapping(value = "/add")
    public String createUser(@ModelAttribute User users, Model model, BindingResult bindingResult) {
    	System.out.println(users);
    	users.setRoles("USER");
        User user = userService.createUser(users);
        return "redirect:/index";
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public String deleteUser(@RequestParam String UserId) {
        userService.deleteUser(Integer.parseInt(UserId));
        return "redirect:/index";
    }
}