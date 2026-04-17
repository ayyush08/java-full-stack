package com.firstspringapp.service;

import com.firstspringapp.bean.UserConfig;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserConfig userConfig;

    public UserService(final UserConfig userConfig) {
        this.userConfig = userConfig;
    }

    public void print() {
        System.out.println("Name: " + userConfig.getName());
        System.out.println("Class: " + userConfig.getClassName());
    }
}