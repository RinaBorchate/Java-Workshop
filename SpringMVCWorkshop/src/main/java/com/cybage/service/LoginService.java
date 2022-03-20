package com.cybage.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.cybage.model.Book;
import com.cybage.model.User;

@Service
public class LoginService {
List<User> userList=new ArrayList<User>();
	
	public LoginService() {
		userList.add(new User("rina@cybage.com","rina"));
		userList.add(new User("sakshi@cybage.com", "sakshi"));		
	}
	

	public User getUser(String username, String password) {
		User user1=userList.stream().filter(user->user.getEmail().equals(username) && user.getPassword().equals(password)).findFirst().get();
		return user1;
		
	}

}
