package com.mimu.simple.comn.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

public class SimpleRocketMqProducer {

    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("");
        try {
            producer.start();
            producer.send(new Message("topic", "tag", "message".getBytes()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
