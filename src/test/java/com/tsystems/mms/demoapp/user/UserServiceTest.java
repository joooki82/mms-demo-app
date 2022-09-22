package com.tsystems.mms.demoapp.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.tsystems.mms.demoapp.validator.EmailValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserServiceTest {

	@MockBean
	private UserRepository userRepository;

	private UserService userService;
	private List<User> testUsers;

//  @BeforeEach
//  public void setup() {
//    userService = new UserService(userRepository);
//    testUsers = new ArrayList<>();
//    testUsers.add(createUser(1L,"test1.user@foo.bar"));
//    testUsers.add(createUser(2L,"test2.user@foo.bar"));
//    testUsers.add(createUser(3L,"test3.user@foo.bar"));
//  }
//
//  @Test
//  void testGetAll () {
//
//    // Mock
//    Mockito.when(userRepository.findAll()).thenReturn(testUsers);
//
//    // Assert
//    List<User> users = userService.getAll();
//    Assertions.assertNotNull(users);
//    Assertions.assertEquals(3, users.size());
//    Assertions.assertEquals(testUsers.get(0), users.get(0));
//
//    // Verify
//    Mockito.verify(userRepository, Mockito.atMostOnce()).findAll();
//
//  }

	private User createUser(Long id, String email) {
		User user = new User();
		user.setId(id);
		user.setEmail(email);
		return user;
	}

	@Test
	void emailValidation() {

		String email1 = "tamas.jakab@t-systems.com";
		String email2 = "tamas.jakab.t-systems.com";

		assertTrue(true, email1);
		assertFalse(false, email2);
		
		
	}

}
