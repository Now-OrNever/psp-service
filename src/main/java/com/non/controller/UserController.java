package com.non.controller;


import com.non.model.User;
import com.non.repository.UserRepository;
import com.non.service.UserService;
import com.non.util.PspServiceConstants;
import com.non.util.Role;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;


import java.util.Map;


@RestController
@CrossOrigin(origins = PspServiceConstants.ACCESS_CONTROL_ALLOW_ORIGIN_VALUE, allowedHeaders = PspServiceConstants.ACCESS_CONTROL_ALLOW_ORIGIN_VALUE)
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }



    @GetMapping("/users")
    public Map<String, Object> currentUser(OAuth2AuthenticationToken oAuth2AuthenticationToken){

        return oAuth2AuthenticationToken.getPrincipal().getAttributes();
    }
    @PostMapping("/users")
    public void addUser(@RequestBody User user) {

        String first_name = user.getFirstName();
        String last_name = user.getLastName();
        String email = user.getEmail();
        String username = user.getUsername();
        Role role = user.getRole();

        if(role != null)
        {
            user = new User(username, first_name, last_name, email, role);

        }
        else
        {
             user = new User(username, first_name, last_name, email);
        }
        userService.addNewUser(user);

    }

//    @GetMapping ("/auth")
//    public OAuth2AuthenticatedPrincipal currentUser(OAuth2AuthenticationToken authentication) {
//        OAuth2AuthenticatedPrincipal principal = authentication.getPrincipal();
//        User user = new User();
//        user.setUsername(principal.getAttribute("username"));
//        user.setEmail(principal.getAttribute("email"));
//        user.setName(principal.getAttribute("name"));
//        return principal;
//    }
}
