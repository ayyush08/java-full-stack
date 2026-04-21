package com.springaop.restapi;


import com.springaop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {

    @Autowired //Spring will use its IoC container to use the service singleton here
    private UserService userService;

    @GetMapping("/")
    public String userLogin() {
        userService.logIn();
        return "User logged in successfully";
    }

    @GetMapping("/logout")
    public String userLogout() {
        try {
            userService.logout();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "User logged out successfully";
    }

}
