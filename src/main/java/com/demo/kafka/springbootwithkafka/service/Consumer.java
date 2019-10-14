package com.demo.kafka.springbootwithkafka.service;

import com.demo.kafka.springbootwithkafka.model.User;
import com.demo.kafka.springbootwithkafka.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
public class Consumer {
    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);


    @Autowired
    public Consumer(UserRepository userrepository) {
        this.userRepository = userrepository;
    }

    @KafkaListener(topics = "messges", groupId = "group_id")
    public void consume(String message) {
        logger.info(String.format("$$ -> Consumed Message -> %s", message));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    @KafkaListener(topics = "users", groupId = "group_id", containerFactory = "userKafkaListenerContainerFactory")
    public void saveUser(User user) {
        user.setId(UUID.randomUUID().toString());
        Object savedUser = userRepository.save(user);
        System.out.println(savedUser);
    }
}
