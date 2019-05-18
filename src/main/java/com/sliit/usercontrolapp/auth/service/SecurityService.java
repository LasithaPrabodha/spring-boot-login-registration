package com.sliit.usercontrolapp.auth.service;

public interface SecurityService{
	String findLoggedInUsername();

	void autoLogin(String username, String password);
}