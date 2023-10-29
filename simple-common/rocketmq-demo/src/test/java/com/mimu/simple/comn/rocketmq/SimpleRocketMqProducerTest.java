package com.mimu.simple.comn.rocketmq;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SimpleRocketMqProducerTest extends SimpleRocketMQNote {
    private static final Logger logger = LoggerFactory.getLogger(SimpleRocketMqProducerTest.class);

    SimpleRocketMqProducer mqProducer = new SimpleRocketMqProducer(nameStrAddr, producer_group);

    @Test
    public void send() {
        mqProducer.send(topic, "first message");
        mqProducer.send(topic, "test", "first tag message");
    }
}