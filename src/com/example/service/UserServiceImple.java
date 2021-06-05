package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.dto.User;

@Service
public class UserServiceImple implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public void addUser(User user) {
		userDao.registration(user);
	}

	@Override
	public boolean checkUser(User user) {
		
		return userDao.login(user);
	}
	
}
