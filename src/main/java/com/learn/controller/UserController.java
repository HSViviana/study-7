package com.learn.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entity.User;
import com.learn.service.UserService;

// 1
@RestController
// 2
@RequestMapping("/users")
public class UserController {

	// 5
	private final UserService userService;

	UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping // d
	// 3
	public List<User> getAllUsers() { // a
		List<User> result = null; // b // String을 삭제 후 List<User>로 변경
//		result = "getAllUsers() 호출"; // e
		result = userService.getAllUsers(); // f: e 주석 처리 후 변경
		return result; // c
	}

	@PostMapping // d
	// 4
//public String createUser(@RequestParam String name) { // a, // f: @RequestParam String name
	public User createUser(@RequestParam String name) { // h: String을 User로 변경
		User result = null; // b
//		result = "createUser() 호출 : " + name; // e, // g: +name
		result = userService.createUser(name); // h: g 주석 처리 후 변경
		return result; // c

	}

}
