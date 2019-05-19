package com.sliit.usercontrolapp.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import com.sliit.usercontrolapp.auth.model.User;
import com.sliit.usercontrolapp.auth.service.UserService;

public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {
	@Autowired
	private UserService userService;

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		String delete = request.getParameter("delete");
		if (delete != null) {
			String username = authentication.getName();
			User user = userService.findByUsername(username);
			
			userService.delete(user);
		}

		super.onLogoutSuccess(request, response, authentication);
	}
}