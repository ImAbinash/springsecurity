package com.khub.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

	@GetMapping("/myCards")
	public String getCardController() {
		return "welcome to account controller";
	}
}