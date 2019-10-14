package com.demo.kafka.springbootwithkafka;

import com.demo.kafka.springbootwithkafka.service.Consumer;
import com.demo.kafka.springbootwithkafka.service.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;

@SpringBootApplication
public class SpringBootWithKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWithKafkaApplication.class, args);
    }


}
