package com.tajutechgh.springbootkafka.controller;

import com.tajutechgh.springbootkafka.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageController {

    @Autowired
    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {

        this.kafkaProducer = kafkaProducer;
    }

    @RequestMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam String message) {

        kafkaProducer.sendMessage(message);

        return ResponseEntity.ok("Message sent to the topic");
    }
}