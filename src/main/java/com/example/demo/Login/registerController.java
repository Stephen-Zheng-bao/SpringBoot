package com.example.demo.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.User.User;
@Controller
public class registerController {
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("user",new User());
		return "register";
	}
	@PostMapping("/register")
	public String sendRegisterForm(@ModelAttribute User user,Model model, BindingResult bindingResult) {
		System.out.println(user);
		return "Welcome";
	}
}
