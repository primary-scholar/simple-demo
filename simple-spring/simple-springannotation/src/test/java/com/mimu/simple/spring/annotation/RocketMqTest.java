package com.mimu.simple.spring.annotation;

import com.alibaba.fastjson.JSONObject;
import com.mimu.simple.spring.annotation.mq.RocketMqConfig;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author luyahui
 * @date 2023/12/7
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RocketMqConfig.class)
public class RocketMqTest {

    @Autowired
    private DefaultMQProducer mqProducer;

    @Test
    public void sendMsg() throws RemotingException, MQClientException, InterruptedException, MQBrokerException {
        String topic = "test-mq-producer-group";
        String msg = "hello abc again";
        Message message = new Message(topic, msg.getBytes());

        SendResult send = mqProducer.send(message);
        System.out.println(JSONObject.toJSONString(send));
    }
}
