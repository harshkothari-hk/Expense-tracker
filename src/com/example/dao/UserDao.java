package com.example.dao;

import com.example.dto.User;

public interface UserDao {
	void registration(User user);
	boolean login(User user);
}
