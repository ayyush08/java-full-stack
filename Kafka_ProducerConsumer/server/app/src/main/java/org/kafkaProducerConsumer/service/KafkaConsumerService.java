package org.kafkaProducerConsumer.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final Counter kafkaEventsCounter;

    public KafkaConsumerService(MeterRegistry meterRegistry) {

        kafkaEventsCounter = Counter.builder("kafka_events_received_total")
                .description("Total Kafka events received")
                .register(meterRegistry);
    }

    @KafkaListener(topics = "testTopic", groupId = "metrics-consumer-group")
    public void listen(String eventData) {

        System.out.println("Received event: " + eventData);

        kafkaEventsCounter.increment();
    }
}
