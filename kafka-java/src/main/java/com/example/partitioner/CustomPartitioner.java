package com.example.partitioner;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * @author LinYongJin
 * @date 2019/10/7 18:40
 */
public class CustomPartitioner implements Partitioner {

    @Override
    public int partition(String s, Object o, byte[] bytes, Object o1, byte[] bytes1, Cluster cluster) {
        //获取当前主题存活的分区数量
        Integer count = cluster.partitionCountForTopic(s);
        //使用key的hashcode与存活的分区数进行取余运算
        return 1;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
