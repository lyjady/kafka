package com.example.kafkaspringboot.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author LinYongJin
 * @date 2019/10/13 16:55
 */
@Component
public class MessageConsumer {

    @KafkaListener(topics = "java-api")
    public void receiveMessage(ConsumerRecord<String, String> consumerRecord) {
        Optional<String> kafkaMessage = Optional.ofNullable(consumerRecord.value());
        if (kafkaMessage.isPresent()) {
            System.out.println("主题: " + consumerRecord.topic() + ", 分区: " + consumerRecord.partition() + ", key: " + consumerRecord.key() + ", value:" + consumerRecord.value() + ", offset: " + consumerRecord.offset());
        }
    }
}
