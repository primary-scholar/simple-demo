package com.mimu.simple.spring.annotation.mq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author luyahui
 * @date 2023/12/7
 * @description
 */
@Configuration
public class RocketMqConfig {

    @Bean
    public DefaultMQProducer createMq() {
        DefaultMQProducer mqProducer = new DefaultMQProducer("est-mq-producer-group");
        mqProducer.setNamesrvAddr("172.23.140.194:9876");
        mqProducer.setMqClientApiTimeout(30000);
        mqProducer.setSendMsgTimeout(30000);
        try {
            mqProducer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        return mqProducer;
    }
}
