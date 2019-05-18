package com.sliit.usercontrolapp.auth.repository;

import com.sliit.usercontrolapp.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}