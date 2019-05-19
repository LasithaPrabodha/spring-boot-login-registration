package com.sliit.usercontrolapp.auth.validator;

import com.sliit.usercontrolapp.auth.model.User;
import com.sliit.usercontrolapp.auth.service.UserService;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
	@Autowired
	private UserService userService;

	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	public void validate(Object o, Errors errors) {
		User user = (User) o;

		if (user.getFirstName() != null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");
			if (user.getFirstName().length() > 50) {
				errors.rejectValue("firstName", "Size.userForm.firstName");
			}

			if (user.getLastName().length() > 50) {
				errors.rejectValue("lastName", "Size.userForm.lastName");
			}

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");

			String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
			if (!Pattern.compile(emailRegex).matcher(user.getEmail()).matches()) {
				errors.rejectValue("email", "Invalid.userForm.email");
			}

			if (user.getEmail().length() > 120) {
				errors.rejectValue("email", "Size.userForm.email");
			}

		}

		if (user.getUsername() != null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
			if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
				errors.rejectValue("username", "Size.userForm.username");
			}

			if (userService.findByUsername(user.getUsername()) != null) {
				errors.rejectValue("username", "Duplicate.userForm.username");
			}

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
			if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
				errors.rejectValue("password", "Size.userForm.password");
			}

			if (!user.getPasswordConfirm().equals(user.getPassword())) {
				errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
			}
		}

	}
}