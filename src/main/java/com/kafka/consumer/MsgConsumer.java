package com.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**消息消费者
 * Created by lvyihang on 17/5/29.
 */
@Component
public class MsgConsumer {
    Logger logger = LoggerFactory.getLogger(MsgConsumer.class);
    @KafkaListener(topics = {"test"},group = "myGroup")
    public String processMsg(ConsumerRecord data){
        System.out.println("topic: "+data.topic());
        System.out.println("key: "+data.key());
        System.out.println("value: "+data.value());
        return data.value().toString();
    }

    @KafkaListener(topics = {"my-replicated-topic2"},group = "myGroup")
    public String processMsg2(ConsumerRecord data){
        System.out.println("topic: "+data.topic());
        System.out.println("key: "+data.key());
        System.out.println("value: "+data.value());
        return data.value().toString();
    }

}
