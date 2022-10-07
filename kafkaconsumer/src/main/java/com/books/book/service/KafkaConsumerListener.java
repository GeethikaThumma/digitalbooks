package com.books.book.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.books.book.entity.BookEntity;

@Service
public class KafkaConsumerListener {


    private static final String TOPIC = "kafka-topic-sample";

    @KafkaListener(topics = TOPIC, groupId="group_id", containerFactory = "userKafkaListenerFactory")
    public void consumeJson(BookEntity book) {
        System.out.println("Consumed JSON Message: " + book);
    }
}
