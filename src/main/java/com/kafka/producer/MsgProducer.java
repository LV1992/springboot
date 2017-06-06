package com.kafka.producer;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 消息生产者
 * Created by lvyihang on 17/5/29.
 */
@Component
public class MsgProducer {
    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;
    Logger logger = LoggerFactory.getLogger(MsgProducer.class);

    public void send(List<String> msgs) {
        for (String msg : msgs) {
            kafkaTemplate.send("test", msg);
        }
        kafkaTemplate.send("my-replicated-topic2", "MSG");


    }


}