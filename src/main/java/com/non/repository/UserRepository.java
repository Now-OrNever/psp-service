package com.non.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.non.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	Optional<User> findByUserName(String userName);

}
