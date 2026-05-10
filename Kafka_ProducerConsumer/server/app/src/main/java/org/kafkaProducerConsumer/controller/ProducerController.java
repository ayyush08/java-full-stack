package org.kafkaProducerConsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class ProducerController {

    private static final String TOPIC_NAME = "testTopic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/event")
    public String sendEventToKafka(@RequestBody String eventData) {

        kafkaTemplate.send(TOPIC_NAME, "userEvent", eventData);

        return "Event sent successfully";
    }
}