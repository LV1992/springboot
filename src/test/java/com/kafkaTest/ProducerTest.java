//package com.kafkaTest;
//
//import org.apache.kafka.clients.producer.*;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by lvyihang on 17/5/31.
// */
//public class ProducerTest extends TestBase {
//
//    protected Properties props = new Properties();
//
//    @Before
//    public void init() {
//
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafka_server);
//        props.put(ProducerConfig.ACKS_CONFIG, "all");
//        props.put(ProducerConfig.RETRIES_CONFIG, 0);
//        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
//        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
//        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//
////        props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG ,MyPartitioner.class) ;
//    }
//
//    @Test
//    public void test() throws InterruptedException {
//
//        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
//
//        // 发送消息
//        for (int i = 0; i < 10; i++) {
//            producer.send(new ProducerRecord<String, String>(topic, Integer.toString(i), Integer.toString(i)), new Callback() {
//                @Override
//                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
//                    if (e == null) {
//                        System.out.printf("offset = %d ,partition = %d \n", recordMetadata.offset() ,recordMetadata.partition());
//                    } else {
//                        log.error("send error !" ,e);
//                    }
//                }
//            });
//        }
//
//        TimeUnit.SECONDS.sleep(3);
//        producer.close();
//
//    }
//
//}