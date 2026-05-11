package com.userservice.consumer;

import com.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class AuthServiceConsumer {

    private UserRepository userRepository; //not recommended to use autowire cuz sometimes does not work in spring

    @Autowired
    AuthServiceConsumer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(Object eventData){
        try{

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
