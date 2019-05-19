package com.sliit.usercontrolapp.auth.controller;

import com.sliit.usercontrolapp.auth.model.User;
import com.sliit.usercontrolapp.auth.service.SecurityService;
import com.sliit.usercontrolapp.auth.service.UserService;
import com.sliit.usercontrolapp.auth.validator.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@GetMapping({ "/", "/welcome" })
	public String welcome(Model model) {
		return "welcome";
	}

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "registration";
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		userService.save(userForm);

		securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

		return "redirect:/welcome";
	}

	@GetMapping("/edit-profile")
	public String editProfile(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String username = authentication.getName();
			User currentUser = userService.findByUsername(username);
			model.addAttribute("userForm", currentUser);
		} else {
			model.addAttribute("userForm", new User());
		}

		return "edit-profile";
	}

	@PutMapping("/edit-profile")
	public String saveProfile(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "edit-profile";
		}

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String username = authentication.getName();
			User user = userService.findByUsername(username);

			user.setEmail(userForm.getEmail());
			user.setFirstName(userForm.getFirstName());
			user.setLastName(userForm.getLastName());

			userService.save(user);
		}

		return "redirect:/welcome";

	}

}
