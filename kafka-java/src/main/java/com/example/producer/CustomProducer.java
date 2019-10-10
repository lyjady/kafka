package com.example.producer;

import com.example.utils.CommonUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author LinYongJin
 * @date 2019/10/7 16:10
 */
public class CustomProducer {

    public static void main(String[] args) throws InterruptedException {
        Properties kafkaProperties = CommonUtils.getKafkaProducerProperties();
        KafkaProducer<String, String> producer = new KafkaProducer<>(kafkaProperties);
        for (int i = 0; i < 6; i++) {
            producer.send(new ProducerRecord<>("java-api", "key" + i, "LYJ-" + i), ((recordMetadata, e) -> {
                if (e != null) {
                    e.printStackTrace();
                } else {
                    System.out.println("发送成功,分区: " + recordMetadata.partition() + ", 偏移量: " + recordMetadata.offset());
                }
            }));
        }
//        Thread.sleep(100);
        producer.close();
    }
}
