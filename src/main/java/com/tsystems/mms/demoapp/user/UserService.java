package com.tsystems.mms.demoapp.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsystems.mms.demoapp.common.exception.ResourceNotFoundException;

import java.util.List;

/**
 * This service manages all user.
 */
@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * Find all users from the database.
	 * 
	 * @return List of users.
	 */
	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {

		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

	}

	public Long saveUser(User user) {
		User savedUser = userRepository.save(user);
		return savedUser.getId();
	}

}
