package com.example.inbound.test.controller;

import java.net.http.HttpRequest;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class InboundController {
	
	@PostMapping("/test/post")
	public ResponseEntity<?> TestPost() {
			RestTemplate rst = new RestTemplate();
			ResponseEntity<String> authResponse = rst.postForEntity("http://localhost:5000/api/test/post", null, String.class);
		return new ResponseEntity<>(authResponse.getBody(),HttpStatus.OK);
	}
}
