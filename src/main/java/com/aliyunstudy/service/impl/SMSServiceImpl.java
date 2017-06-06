package com.aliyunstudy.service.impl;

import com.aliyunstudy.service.SMSService;
import com.dahantc.api.sms.json.JSONHttpClient;
import com.dahantc.api.sms.json.SmsData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by lvyihang on 17/5/17.
 */
@Service
public class SMSServiceImpl implements SMSService {
    private static String account = "dh64351";// 用户名（必填）
    private static String password = "XwC1BMaG";// 密码（必填）
    private static String phone = "13262529131"; // 手机号码（必填,多条以英文逗号隔开）
    public static String sign = "【云秒付】"; // 短信签名（必填）
    public static String subcode = ""; // 子号码（可选）
    public static String msgid = UUID.randomUUID().toString().replace("-", ""); // 短信id，查询短信状态报告时需要，（可选）
    public static String sendtime = ""; // 定时发送时间（可选）
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(SMSServiceImpl.class);
    @Override
    public String sendSms(String phone) {
        String sendBatchRes = null;
        try {
            String content = "您好！你有一个快递,请注意查收。";// 短信内容（必填）

            JSONHttpClient jsonHttpClient = new JSONHttpClient("http://www.dh3t.com");
//            JSONHttpClient jsonHttpClient = new JSONHttpClient("http://www.dh3t.com/json/sms/Submit");
//            jsonHttpClient.setRetryCount(1);
//            String sendhRes = jsonHttpClienst.sendSms(account, password, phone, content, sign, subcode,msgid,sendtime);
//            LOG.info("提交单条普通短信响应：" + sendhRes);

            List<SmsData> list = new ArrayList<SmsData>();
            list.add(new SmsData(phone+",1111111,15133,8786465,444545", content, msgid, sign, subcode, sendtime));
            list.add(new SmsData("11777134", content, msgid, sign, subcode, sendtime));
            sendBatchRes = jsonHttpClient.sendBatchSms(account, password, list);
            LOG.info("提交批量短信响应：" + sendBatchRes);

            // String reportRes = jsonHttpClient.getReport(account, password);
            // LOG.info("获取状态报告响应：" + reportRes);
            //
            // String smsRes = jsonHttpClient.getSms(account, password);
            // LOG.info("获取上行短信响应：" + smsRes);

        } catch (Exception e) {

            LOG.error("应用异常", e);
        }
        return sendBatchRes;
    }

    @Override
    public String sendBatchSms(String[] phones) {
        return null;
    }
}
