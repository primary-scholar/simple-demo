package com.mimu.simple.comn.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;


public class SimpleRocketMqConsumer {


    private DefaultMQPushConsumer mqPushConsumer;

    public SimpleRocketMqConsumer(String nameSrvAddr, String topic, String consumerGroup) {
        initConsumer(nameSrvAddr, topic, consumerGroup, "*");
    }

    public SimpleRocketMqConsumer(String nameSrvAddr, String topic, String consumerGroup, String subExpression) {
        initConsumer(nameSrvAddr, topic, consumerGroup, subExpression);
    }

    public void registerMessageListener(MessageListenerConcurrently concurrentlyListener) {
        mqPushConsumer.registerMessageListener(concurrentlyListener);
    }

    public void registerMessageListener(MessageListenerOrderly orderlyListener) {
        mqPushConsumer.registerMessageListener(orderlyListener);
    }

    private void initConsumer(String nameSrvAddr, String topic, String consumerGroup, String subExpression) {
        mqPushConsumer = new DefaultMQPushConsumer(consumerGroup);
        mqPushConsumer.setNamesrvAddr(nameSrvAddr);
        try {
            mqPushConsumer.subscribe(topic, subExpression);
        } catch (MQClientException e) {
            throw new RuntimeException(e);
        }
    }

    public void start() {
        try {
            mqPushConsumer.start();
        } catch (MQClientException e) {
            throw new RuntimeException(e);
        }
    }


}
