package com.example.utils;

import com.example.partitioner.CustomPartitioner;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.Properties;

/**
 * @author LinYongJin
 * @date 2019/10/7 16:16
 */
public class CommonUtils {

    private static final String BOOTSTRAP_SERVERS = "linux:9092";

    public static Properties getKafkaProducerProperties() {
        Properties properties = new Properties();
        //指定Kafka地址
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        //指定key序列化的方式
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        //指定value序列化的方式
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        //ack应答级别
        properties.put(ProducerConfig.ACKS_CONFIG, "all");
        //重试次数
        properties.put(ProducerConfig.RETRIES_CONFIG, "1");
        //批次大小(API是按批次向Kafka发送数据)
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        //等待时间(ms,发送消息的频率)
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        //缓冲区大小
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        //指定自定义的分区器
//        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, "com.example.partitioner.CustomPartitioner");

        return properties;
    }

    public static Properties getKafkaConsumerProperties() {
        Properties properties = new Properties();
        //指定kafka的地址
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        //指定key反序列化的方式
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        //指定value反序列化的方式
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        //开启自动提交
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        //自动提交延迟
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 1000);
        //消费者组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "god");
        //开启offset重置类似命令行中的--from-beginning
//        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return properties;
    }
}
