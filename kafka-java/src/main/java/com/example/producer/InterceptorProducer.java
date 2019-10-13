package com.example.producer;

import com.example.utils.CommonUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * @author LinYongJin
 * @date 2019/10/13 15:52
 */
public class InterceptorProducer {

    public static void main(String[] args) throws InterruptedException {
        Properties properties = CommonUtils.getKafkaProducerProperties();
        List<String> interceptors = new ArrayList<>();
        interceptors.add("com.example.interceptor.CountInterceptor");
        interceptors.add("com.example.interceptor.TimeInterceptor");
        properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, interceptors);
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        for (int i = 0; i < 5; i++) {
            producer.send(new ProducerRecord<>("java-api", "key-" + i, "Interceptor-" + i));
        }
        producer.close();
    }
}
