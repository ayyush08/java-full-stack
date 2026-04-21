package com.springaop.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Getter
    @Setter //Lombok Annotations instead of manually writing
    @AllArgsConstructor //makes constructor and initializes all variables
    public class User{
        private String name;
        private int age;
        private String address;
    }

    private User user;

    public UserService(){
        user =  new User("Curator",22,"Azamgarh, India");
    }

    public void logIn(){
        System.out.println("Logging user in");
    }


    public void logout() throws Exception{
        System.out.println("logging user out");
        throw new Exception("unable to logout the user");
    }
}
