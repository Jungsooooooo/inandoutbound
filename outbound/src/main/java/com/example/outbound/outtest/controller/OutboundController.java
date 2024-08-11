package com.example.outbound.outtest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OutboundController {
	
	@PostMapping("/test/post")
	public String outbound() {
		String test = "t";
		return "outbound success";
	}
}
