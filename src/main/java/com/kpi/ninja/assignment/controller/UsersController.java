package com.kpi.ninja.assignment.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kpi.ninja.assignment.model.User;
import com.kpi.ninja.assignment.service.UserService;
import com.kpi.ninja.assignment.validator.UserValidator;

@Controller
@RequestMapping("/users/")
public class UsersController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping("showForm")
	public String showUserForm(User user) {
		return "add-user";
	}

	    @GetMapping("list")
	    public String showUpdateForm(Model model) {
	        model.addAttribute("users", userService.getAllUsers());
	        return "index";
	    }

	    @PostMapping("add")
	    public String addUser(@Validated User user, BindingResult result, Model model) {
	    	if(result.hasErrors()) {
				return "add-user";
			}
	        userService.addUser(user);
	        return "redirect:list";
	    }

	    @GetMapping("edit/{id}")
	    public String showUpdateForm(@PathVariable("id") int id, Model model) {
	        User user = userService.getUserById(id);
	        model.addAttribute("user", user);
	        return "update-user";
	    }

	    @PostMapping("update/{id}")
	    public String updateUser(@PathVariable("id") int userId, @Valid User user, BindingResult result,
	        Model model) {
	    	userValidator.validateRequest(userId);
	    	userService.saveOrupdateUser(user);
	        model.addAttribute("users", userService.getAllUsers());
	        return "index";
	    }

	    @GetMapping("delete/{id}")
	    public String deleteUser(@PathVariable("id") int userId, Model model) {
	    	userValidator.validateRequest(userId);
	        userService.delete(userId);
	        model.addAttribute("users", userService.getAllUsers());
	        return "index";
	    }
	

}
