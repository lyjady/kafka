package com.example.kafkaspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author LinYongJin
 * @date 2019/10/7 21:33
 */
@Service
public class MessageService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Scheduled(fixedDelay = 1000)
    public void sendMessage() {
        kafkaTemplate.send("java-api", "springboot-message");
    }
}
