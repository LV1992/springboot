package com.aliyunstudy.controller;

import com.aliyunstudy.service.SMSService;
import com.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lvyihang on 17/5/17.
 */
@Controller
public class TestController {
    @Autowired
    private SMSService smsService;
    @Autowired
    private RedisService redisService;

    @GetMapping("sms/{tel}")
    public void send(@PathVariable String tel){
        smsService.sendSms(tel);
    }

    @GetMapping("redis/set")
    public void set(@RequestParam String key,@RequestParam String value){
        redisService.set(key,value);
    }

    @GetMapping("redis/remove")
    public void remove(@RequestParam String key){
        redisService.remove(key);
    }
}
