package com.mimu.simple.comn.rocketmq;


import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.protocol.heartbeat.MessageModel;


public class SimpleRocketMqConsumerTest extends SimpleRocketMQNote {

    public static void main(String[] args) throws MQClientException, InterruptedException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumer_group);
        consumer.setNamesrvAddr(nameStrAddr);
        consumer.subscribe(topic, "*");
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            System.out.println(JSONObject.toJSONString(msgs));
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        consumer.setPullInterval(1);
        consumer.setMessageModel(MessageModel.CLUSTERING);
        consumer.start();
        System.out.println("end");
    }

}