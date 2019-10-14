package com.demo.kafka.springbootwithkafka.service;


import com.demo.kafka.springbootwithkafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class Producer {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "users";
    private static final String StringTOPIC = "messges";
    @Autowired
    private KafkaTemplate<String, User> userKafkaTemplate;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        logger.info(String.format("$$ -> Producing message --> %s",message));
        ListenableFuture<SendResult<String, String>> send = this.kafkaTemplate.send(StringTOPIC, message);
        System.out.println(send);
    }

    public void saveUserProducer(String name){
        ListenableFuture<SendResult<String,String>> send = this.kafkaTemplate.send("transaction_test", name);
        System.out.println(send);
    }

    public void saveUserProducer(User user){
        userKafkaTemplate.send(TOPIC,user);
    }
}
