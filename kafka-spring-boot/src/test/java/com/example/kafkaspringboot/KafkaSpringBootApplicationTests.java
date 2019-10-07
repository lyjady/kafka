package com.example.kafkaspringboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaSpringBootApplicationTests {

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Test
    public void contextLoads() {
        for (int i = 0; i < 6; i++) {
            kafkaTemplate.send("java-api", "springboot-message-" + i);
        }
    }

}
