package com.kpi.ninja.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpi.ninja.assignment.dao.UserRepository;
import com.kpi.ninja.assignment.exception.UserApiException;
import com.kpi.ninja.assignment.model.User;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(user1 -> users.add(user1));
		return users;
	}

	public User getUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent())
		{
			return user.get();
		}
		else
		{
			throw new UserApiException("BAD REQUEST","403","NO USERID FOUND");
		}
	}

	public String addUser(User books) {
		userRepository.save(books);
		return "User added successfully";
	}

	public void delete(int id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent())
		{
		userRepository.deleteById(id);
		}
		else
		{
			throw new UserApiException("BAD REQUEST","403","NO USERID FOUND");
		}
	}

	public void saveOrupdateUser(User user) {
		userRepository.save(user);
	}
}
