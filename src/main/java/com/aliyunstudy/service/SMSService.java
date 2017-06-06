package com.aliyunstudy.service;

/**
 * Created by lvyihang on 17/5/17.
 */
public interface SMSService {
    String sendSms(String phone);
    String sendBatchSms(String[] phones);
}
