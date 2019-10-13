package com.example.kafkaspringboot.listener;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

/**
 * @author LinYongJin
 * @date 2019/10/7 21:28
 */
@Component
public class KafkaSendListener implements ProducerListener {

    @Override
    public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
        System.out.println("主题: " + producerRecord.topic() + ", 分区： " + recordMetadata.partition() + ", 偏移量: " + recordMetadata.offset() + ", 消息: " + producerRecord.value());
    }

    @Override
    public void onError(String topic, Integer partition, Object key, Object value, Exception exception) {
        exception.printStackTrace();
    }
}
