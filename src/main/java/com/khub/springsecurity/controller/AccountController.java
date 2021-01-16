package com.khub.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@GetMapping("/myAccount")
	public String getAccountController() {
		return "welcome to account controller";
	}
}
