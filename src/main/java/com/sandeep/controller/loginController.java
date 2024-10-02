package com.sandeep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sandeep.client.RegistrationClient;

@Controller
public class loginController {
	
	@Autowired
	private RegistrationClient registrationClient;
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}
	
	@GetMapping("/redirectRegister")
	public String redirectToRegistration() {
		registrationClient.getAllUser();
		return "redirect:http://localhost:1202/allUser";
	}

}
