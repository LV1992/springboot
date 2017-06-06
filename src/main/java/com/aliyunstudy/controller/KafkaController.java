package com.aliyunstudy.controller;

import com.aliyunstudy.service.SMSService;
import com.kafka.consumer.MsgConsumer;
import com.kafka.producer.MsgProducer;
import com.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lvyihang on 17/5/17.
 */
@RestController
public class KafkaController {
    @Autowired
    private MsgProducer producer;
    @Autowired
    private MsgConsumer consumer;

    /**
     * 后台接受list<String> 需要设置value为msg［］ 前端ajax设置为｛msgs：［''，''］｝
     * @param msgs
     */
    @GetMapping("producer")
    public void send(@RequestParam(value = "msgs[]") List<String> msgs){
        producer.send(msgs);
    }

//    @GetMapping("consumer")
//    public void rescive(@RequestParam String key,@RequestParam String value){
//        consumer.processMsg();
//    }

}
