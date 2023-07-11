package com.non.service;

import com.non.model.User;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addNewUser(User user);

    void currentUser(OAuth2AuthenticationToken authentication);
}
