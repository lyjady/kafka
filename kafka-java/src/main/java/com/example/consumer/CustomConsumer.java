package com.example.consumer;

import com.example.utils.CommonUtils;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

/**
 * @author LinYongJin
 * @date 2019/10/10 21:26
 */
public class CustomConsumer {
    public static void main(String[] args) {
        Properties properties = CommonUtils.getKafkaConsumerProperties();
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        //订阅主题
        consumer.subscribe(Collections.singletonList("java-api"));
        while (true) {
            //获取数据
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("key: " + record.key() + ", value: " + record.value() + ", 主题: " + record.topic() + ", 分区" + record.partition() + ", 偏移量: " + record.offset());
            }
        }
    }
}
