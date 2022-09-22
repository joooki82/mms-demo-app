package com.tsystems.mms.demoapp.user;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.mms.demoapp.dto.UserCommand;
import com.tsystems.mms.demoapp.dto.UserDto;

/**
 * RESTful API controller for managing users.
 */
@RestController
@RequestMapping("/api/v1.0")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Finds all users.
	 * 
	 * @return A list of users.
	 */
	@GetMapping("/user")
	public ResponseEntity<List<UserDto>> getUsers() {

		LOGGER.info("Get all users from the database");
		
		return ResponseEntity.ok(userService.getAll());
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {

		LOGGER.info("Get one user by id from the database");
		return ResponseEntity.ok(userService.getUserById(id));
	}
	
	@PostMapping("/user")
	public ResponseEntity<URI> saveUser(@RequestBody User user) {
		LOGGER.info("User has been saved to the database");
		Long userId = userService.saveUser(user);
		return ResponseEntity.created(URI.create("/api/v1.0/user/" + userId)).build();
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserCommand userCommand) {

		LOGGER.info("User has been updated in the database");
		userService.updateUser(id, userCommand);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

		LOGGER.info("User deleted from the database");
		userService.deleteUser(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/userassigntoorganisation")
	public ResponseEntity<Void> assignUserToOrganisationalUnit(@RequestParam(name ="userId") Long userId, @RequestParam(name="organisationalId") Long organisationalId) {

		LOGGER.info("User assined to an organisational unit int the database");
		userService.assignUserToOrganisation(userId, organisationalId);
		return ResponseEntity.ok().build();
	}
	
	
	
	

}