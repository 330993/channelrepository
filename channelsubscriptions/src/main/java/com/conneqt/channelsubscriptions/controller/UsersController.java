package com.conneqt.channelsubscriptions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.conneqt.channelsubscriptions.model.Users;
import com.conneqt.channelsubscriptions.service.UsersService;

@RestController
public class UsersController {
	@Autowired
	private UsersService userService;

	@PostMapping("/api/private/add")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> addUser(@RequestBody Users user) {
		Users usr=userService.addUser(user);
		if(usr!=null && usr.getUserId()!=null) {
			return new ResponseEntity<Users>(usr,HttpStatus.OK);
		}
		return new ResponseEntity<String>("User not added, please try once again",HttpStatus.OK);
	}
	
	@PutMapping("/api/private/assignroletouser")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> assignRoleToUser(@RequestBody Users user) {
		Users usr=userService.assignRoleToUser(user);
		if(usr!=null && usr.getUserId()!=null) {
			return new ResponseEntity<Users>(usr,HttpStatus.OK);
		}
		return new ResponseEntity<String>("User not added, please try once again",HttpStatus.OK);
	}
	
	@PostMapping("/api/public/saveuser")
	public String saveUser(@RequestBody Users user) {
		userService.addUser(user);
		return "user added succesfully...";
	}
	
	@GetMapping("/api/public/getallusers")
	@PreAuthorize("hasAuthority('ADMIN')"+"|| hasAuthority('OPERATOR')")
	public ResponseEntity<List<Users>> getAllUsers() {
		List<Users> u=userService.getAllUsers();
		return new ResponseEntity<List<Users>>(u,HttpStatus.OK);
	}
}
