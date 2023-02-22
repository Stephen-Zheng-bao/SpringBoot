package com.example.demo.Misc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MiscController {
	@GetMapping("aboutus")
	public String aboutus() {
		return "/AboutUs-Ehsan/about us";
	}
	@GetMapping("contactus")
	public String contactus() {
		return "contactus";
	}
	@GetMapping("/")
	public String index() {
		return "Welcome";
	}
	
}
