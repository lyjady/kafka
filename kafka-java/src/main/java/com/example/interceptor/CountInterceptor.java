package com.example.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * @author LinYongJin
 * @date 2019/10/13 15:50
 */
public class CountInterceptor implements ProducerInterceptor {

    private int successNumber = 0;

    private int errorNumber = 0;

    @Override
    public ProducerRecord onSend(ProducerRecord producerRecord) {
        return producerRecord;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        if (recordMetadata != null) {
            System.out.println("发送成功");
            successNumber++;
        } else if (e != null) {
            System.out.println("发送失败");
            errorNumber++;
        }
    }

    @Override
    public void close() {
        System.out.println("成功次数: " + successNumber);
        System.out.println("失败次数: " + errorNumber);
    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
