package com.example.service;

import com.example.dto.User;

public interface UserService {
	void addUser(User user);
	boolean checkUser(User user);

}
