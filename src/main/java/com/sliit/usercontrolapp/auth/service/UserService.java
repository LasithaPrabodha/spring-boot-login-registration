package com.sliit.usercontrolapp.auth.service;

import com.sliit.usercontrolapp.auth.model.User;

public interface UserService {
	void save(User user);

	User findByUsername(String username);
}