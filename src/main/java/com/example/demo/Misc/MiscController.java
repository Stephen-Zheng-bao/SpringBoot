package com.example.demo.Misc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MiscController {
	@GetMapping("aboutus")
	public String aboutus() {
		return "/AboutUs/about";
	}
	@GetMapping("contactus")
	public String contactus() {
		return "contactus";
	}
	@GetMapping("navbar")
	public String nav() {
		return "Fragment/navbar";
	}
	@GetMapping("/")
	public String index() {
		return "Homepage/Homepage";
	}
	
}
