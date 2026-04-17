package com.firstspringapp.config;

import com.firstspringapp.bean.UserConfig;
import com.firstspringapp.service.OrderService;
import com.firstspringapp.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserConfig userConfig() {
        UserConfig uc = new UserConfig();
        uc.setName("Ayush");
        uc.setClassName("Curator");
        return uc;
    }

    @Bean
    public OrderService orderService(UserService userService, UserConfig userConfig) {
        return OrderService.createInstance(userService, userConfig);
    }
}