package com.mimu.simple.comn.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SimpleRocketMqProducer {
    private static final Logger logger = LoggerFactory.getLogger(SimpleRocketMqProducer.class);

    private DefaultMQProducer mqProducer;

    public SimpleRocketMqProducer() {
        mqProducer = new DefaultMQProducer("");
    }

    public SimpleRocketMqProducer(String producerGroup) {
        mqProducer = new DefaultMQProducer(producerGroup);
    }

    public SendStatus send(String topic, String msg) {
        return send(topic, null, msg);
    }

    public SendStatus send(String topic, String tag, String msg) {
        logger.info("SimpleRocketMqProducer send msg topic={},tag={},msg={}", topic, tag, msg);
        try {
            mqProducer.start();
            SendResult result = mqProducer.send(new Message(topic, tag, msg.getBytes()));
            return result.getSendStatus();
        } catch (MQClientException | RemotingException | MQBrokerException | InterruptedException e) {
            logger.info("SimpleRocketMqProducer send msg topic={},tag={},msg={} error", topic, tag, msg, e);
            throw new RuntimeException(e);
        }
    }


}
