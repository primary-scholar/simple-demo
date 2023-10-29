package com.mimu.simple.comn.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleRocketMqConsumer {

    private static final Logger logger = LoggerFactory.getLogger(SimpleRocketMqConsumer.class);

    private DefaultMQPushConsumer mqPushConsumer;

    public SimpleRocketMqConsumer(String topic, String consumerGroup) {
        initConsumer(topic, consumerGroup, "*");
    }

    public SimpleRocketMqConsumer(String topic, String consumerGroup, String subExpression) {
        initConsumer(topic, consumerGroup, subExpression);
    }

    void initConsumer(String topic, String consumerGroup, String subExpression) {
        mqPushConsumer = new DefaultMQPushConsumer(consumerGroup);
        try {
            mqPushConsumer.subscribe(topic, subExpression);
        } catch (MQClientException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        SimpleRocketMqConsumer simpleRocketMqConsumer = new SimpleRocketMqConsumer("","");
        simpleRocketMqConsumer.mqPushConsumer.setNamesrvAddr("");

    }


}
