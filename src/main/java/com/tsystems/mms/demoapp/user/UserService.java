package com.tsystems.mms.demoapp.user;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsystems.mms.demoapp.common.exception.NotPropoerEmailAddressException;
import com.tsystems.mms.demoapp.common.exception.ResourceNotFoundException;
import com.tsystems.mms.demoapp.dto.UserCommand;
import com.tsystems.mms.demoapp.dto.UserDto;
import com.tsystems.mms.demoapp.model.OrganisationalUnit;
import com.tsystems.mms.demoapp.service.OrganisationalUnitService;
import com.tsystems.mms.demoapp.validator.EmailValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * This service manages all user.
 */
@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;
	private final OrganisationalUnitService organisationalUnitService;

	@Autowired
	public UserService(UserRepository userRepository, OrganisationalUnitService organisationalUnitService) {
		this.userRepository = userRepository;
		this.organisationalUnitService = organisationalUnitService;
	}

	/**
	 * Find all users from the database.
	 * 
	 * @return List of users.
	 */
	public List<UserDto> getAll() {
		
		List<User> userListFromDatabase = userRepository.findAll();
		
		List<UserDto> userDtoList = new ArrayList();
		
		for (User user : userListFromDatabase) {
			userDtoList.add(new UserDto(
					user.getId(),
					user.getEmail(), 
					user.getFirstName(),
					user.getSurname(), 
					user.getGender().name(),
					user.getOrganisationalUnit().getOrganisationalUnitName()) );
		}
		
		return userDtoList;
	}

	public UserDto getUserById(Long id) {

		
		
		User userFromDataBaseUser = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
		
		UserDto userDto = new UserDto(
				userFromDataBaseUser.getId(),
				userFromDataBaseUser.getEmail(),
				userFromDataBaseUser.getFirstName(),
				userFromDataBaseUser.getSurname(), 
				userFromDataBaseUser.getGender().name(),
				userFromDataBaseUser.getOrganisationalUnit().getOrganisationalUnitName());
		
		return userDto;
	}

	public Long saveUser(User user) throws NotPropoerEmailAddressException {
		
		if (EmailValidator.isValid(user.getEmail())) {
			User savedUser = userRepository.save(user);
			return savedUser.getId();
		} else {
			
			throw new NotPropoerEmailAddressException("Not proper email address: " + user.getEmail());
		}		
	}

	public void updateUser(Long id, UserCommand userCommand) {
		User originalUser = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
		BeanUtils.copyProperties(userCommand, originalUser);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);

	}

	public void assignUserToOrganisation(Long userId, Long organisationalId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
		
		OrganisationalUnit organisationalUnit = organisationalUnitService.getOrganisationalUnitById(organisationalId);
				
		user.setOrganisationalUnit(organisationalUnit);
		
		
	}

}
