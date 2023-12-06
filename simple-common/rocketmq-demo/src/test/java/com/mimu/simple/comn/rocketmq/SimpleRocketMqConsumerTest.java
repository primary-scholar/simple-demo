package com.mimu.simple.comn.rocketmq;


import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.junit.Test;


public class SimpleRocketMqConsumerTest extends SimpleRocketMQNote {

    SimpleRocketMqConsumer consumer = new SimpleRocketMqConsumer(nameStrAddr, topic, consumer_group);

    @Test
    public void consumerTest() {
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            for (MessageExt msg : msgs) {
                String format = String.format("线程%s,消息%s", Thread.currentThread().getName(), msg);
                System.out.println(format);
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        consumer.start();
    }

}