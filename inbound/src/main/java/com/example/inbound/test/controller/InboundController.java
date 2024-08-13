package com.example.inbound.test.controller;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.inbound.model.UserVO;
import com.example.inbound.service.UserService;
import com.example.inbound.test.service.OAuth2TokenService;

@RestController
@RequestMapping("/api")
public class InboundController {
	
	@Autowired
    private UserService userService;
	
	@PostMapping("/test/post")
	public ResponseEntity<?> TestPost() {
			
				List<UserVO> userVO = new ArrayList<>();
		
			try {
				userVO = userService.selectUser();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return ResponseEntity.ok(userVO);
	}


}
