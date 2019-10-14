package com.demo.kafka.springbootwithkafka;

import com.demo.kafka.springbootwithkafka.model.User;
import com.demo.kafka.springbootwithkafka.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    public KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
    }

    @PostMapping(value = "testUserSave")
    public void saveUser(@RequestBody User user){
        this.producer.saveUserProducer(user);
    }
}