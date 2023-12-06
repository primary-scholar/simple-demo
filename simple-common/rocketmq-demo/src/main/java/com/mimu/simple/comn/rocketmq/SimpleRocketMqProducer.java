package com.mimu.simple.comn.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;


public class SimpleRocketMqProducer {
    private static final Logger logger = LoggerFactory.getLogger(SimpleRocketMqProducer.class);

    private DefaultMQProducer mqProducer;

    public SimpleRocketMqProducer(String nameStrAddr, String producerGroup) {
        initMqProducer(nameStrAddr, producerGroup);
    }

    private void initMqProducer(String nameStrAddr, String producerGroup) {
        mqProducer = new DefaultMQProducer(producerGroup);
        mqProducer.setNamesrvAddr(nameStrAddr);
        try {
            mqProducer.start();
        } catch (MQClientException e) {
            logger.info("SimpleRocketMqProducer start error", e);
            throw new RuntimeException(e);
        }
    }

    public void setTimeOut(int ms) {
        mqProducer.setMqClientApiTimeout(ms);
        mqProducer.setSendMsgTimeout(ms);
    }

    public SendStatus send(String topic, String msg) {
        return send(topic, null, msg, null, null);
    }

    public SendStatus send(String topic, String tag, String msg) {
        return send(topic, tag, msg, null, null);
    }

    public SendStatus send(String topic, String tag, String msg, Long timeOut, Integer delayLevel) {
        logger.info("SimpleRocketMqProducer send msg topic={},tag={},msg={}", topic, tag, msg);
        try {
            Message message = new Message(topic, tag, msg.getBytes());
            if (Objects.nonNull(delayLevel)) {
                message.setDelayTimeLevel(delayLevel);
            }
            SendResult result;
            if (Objects.nonNull(timeOut)) {
                result = mqProducer.send(message, timeOut);
            } else {
                result = mqProducer.send(message);
            }
            return result.getSendStatus();
        } catch (MQClientException | RemotingException | MQBrokerException | InterruptedException e) {
            logger.info("SimpleRocketMqProducer send msg topic={},tag={},msg={} error", topic, tag, msg, e);
            throw new RuntimeException(e);
        }
    }

    protected void send(String topic, String tag, String msg, Long timeOut, Integer delayLevel, SendCallback callback) {
        try {
            Message message = new Message(topic, tag, msg.getBytes());
            if (Objects.nonNull(delayLevel)) {
                message.setDelayTimeLevel(delayLevel);
            }
            if (Objects.nonNull(timeOut)) {
                mqProducer.send(message, callback, timeOut);
            } else {
                mqProducer.send(message, callback);
            }
        } catch (MQClientException | RemotingException | InterruptedException e) {
            logger.info("SimpleRocketMqProducer send msg topic={},tag={},msg={} error", topic, tag, msg, e);
            throw new RuntimeException(e);
        }
    }

}
