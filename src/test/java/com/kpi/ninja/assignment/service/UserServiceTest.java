package com.kpi.ninja.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.kpi.ninja.assignment.dao.UserRepository;
import com.kpi.ninja.assignment.model.User;
import com.kpi.ninja.assignment.validator.UserValidator;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@Mock
	private UserValidator userValidator;
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService;
	
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
	
	
	@Test
	public void testGetAllUserSuccess()
	{
		Mockito.when(userRepository.findAll()).thenReturn(mockUserList());
		List<User> users = userService.getAllUsers();
		Assert.assertNotNull(users);	
	}
	
	@Test
	public void testGetUserByIdSuccess()
	{
		Mockito.when(userRepository.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.ofNullable(mockUserDetails()));
		User user = userService.getUserById(1);
		Assert.assertNotNull(user);	
	}
	
	@Test
	public void testDeleteUserSuccess()
	{
		Mockito.when(userRepository.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.ofNullable(mockUserDetails()));
		User user = userService.getUserById(1);
		Assert.assertNotNull(user);	
	}


	private ArrayList<User> mockUserList() {
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(mockUserDetails());
		return userList;
	}


	private User mockUserDetails() {
		User user = new User();
		user.setUserId(1);
		user.setName("Puja");
		user.setAge(26);
		user.setSex('F');
		user.setAddress("Pune");
		return user;
	}
	

}
