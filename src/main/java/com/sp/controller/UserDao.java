package com.sp.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.sp.model.User;

@Service
public class UserDao {
	private List<User> myUserList;
	
	public UserDao() {
		myUserList=new ArrayList<>();
		createUserList();
	}
	
	private void createUserList() {
		  
		User p1=new User("John", "123+aze", "1000", "surname", "lastName");
		User p2=new User("Roberto", "123+aze", "1000", "surname", "lastName");
		User p3=new User("Anna", "123+aze", "1000", "surname", "lastName");
		User p4=new User("Angry Joe", "123+aze", "1000", "surname", "lastName");
		User p5=new User("Ursula", "123+aze", "1000", "surname", "lastName");

		myUserList.add(p1);
		myUserList.add(p2);
		myUserList.add(p3);
		myUserList.add(p4);
		myUserList.add(p5);
	}
	
	public List<User> getUserList() {
		return this.myUserList;
	}
	
	public User addUser(String login, String pwd, String account, String surName, String lastName) {
		User user=new User(login, pwd, account, surName, lastName);
		this.myUserList.add(user);
		return user;
	}




}
