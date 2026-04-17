package com.firstspringapp.service;

import com.firstspringapp.bean.UserConfig;

public class OrderService {

    private final UserService userService;
    private final UserConfig userConfig;

    public OrderService(UserService userService, UserConfig userConfig) {
        this.userService = userService;
        this.userConfig = userConfig;
    }

    public static OrderService createInstance(UserService userService, UserConfig userConfig) {
        return new OrderService(userService, userConfig);
    }
}