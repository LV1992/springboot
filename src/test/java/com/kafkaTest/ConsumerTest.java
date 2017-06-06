//package com.kafkaTest;
//
//import org.apache.kafka.clients.consumer.*;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.Arrays;
//import java.util.Properties;
//
///**
// * Created by lvyihang on 17/5/31.
// */
//public class ConsumerTest extends TestBase {
//
//    private Properties props = new Properties();
//
//    @Before
//    public void init() {
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafka_server);
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "myGroup");
//        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
//        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//    }
//
//    @Test
//    public void test() {
//        Consumer<String, String> consumer = new KafkaConsumer<String, String>(props);
//        consumer.subscribe(Arrays.asList(topic));
////        consumer.assign(Arrays.asList(new TopicPartition(topic, 1)));
//
//        while (true) {
//            ConsumerRecords<String, String> records = consumer.poll(100);
//            for (ConsumerRecord<String, String> record : records) {
//                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
//            }
//        }
//    }
//
//}
