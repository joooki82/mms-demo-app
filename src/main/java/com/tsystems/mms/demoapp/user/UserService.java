package com.tsystems.mms.demoapp.user;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsystems.mms.demoapp.common.exception.ResourceNotFoundException;
import com.tsystems.mms.demoapp.dto.UserCommand;

import java.util.List;

/**
 * This service manages all user.
 */
@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;

	@Autowired
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

	public void updateUser(Long id, UserCommand userCommand) {
		User originalUser = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with id: " + id));
		BeanUtils.copyProperties(userCommand, originalUser);
	}


}
