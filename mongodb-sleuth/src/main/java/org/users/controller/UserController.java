package org.users.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.users.domain.User;
import org.users.service.UsersService;

import java.util.List;

@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@Slf4j
public class UserController {
	
	@Autowired
	private UsersService usersService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<User> createUser(@RequestBody User user){
		if (StringUtils.isEmpty(user.getId()) || usersService.exists(user.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		usersService.save(user);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(user, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<User>> getUsers(){
		List<User> users = usersService.findAll();
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(users, httpHeaders, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<User> getUser(@PathVariable("id") String id){
		if (!usersService.exists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		User user = usersService.findOne(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<User> updateUser(@PathVariable("id") String id,
										   @RequestBody User user){
		if (!id.equals(user.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (!usersService.exists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		User updatedUser = usersService.save(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") String id){
		if (!usersService.exists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		usersService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
