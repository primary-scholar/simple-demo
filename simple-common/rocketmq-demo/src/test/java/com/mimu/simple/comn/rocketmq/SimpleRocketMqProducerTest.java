package com.mimu.simple.comn.rocketmq;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class SimpleRocketMqProducerTest extends SimpleRocketMQNote {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer(producer_group);
        producer.setNamesrvAddr(nameStrAddr);
        producer.setMqClientApiTimeout(60000);
        producer.setSendMsgTimeout(60000);
        producer.start();

        ArrayList<Message> messageList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            messageList.add(new Message(topic, String.format("this is %s message", i).getBytes(StandardCharsets.UTF_8)));
        }

        for (Message message : messageList) {
            SendResult send = producer.send(message);
            System.out.println(JSONObject.toJSONString(send));
        }
        producer.shutdown();
        System.out.println("end");

    }
}