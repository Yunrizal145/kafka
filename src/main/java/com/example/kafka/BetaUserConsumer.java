package com.example.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class BetaUserConsumer {

    @KafkaListener(
            topics = "yunrizal",
            groupId = "beta-group"
    )
    void consumeUserProfile(@Payload UserBio userBio) {
        if (userBio.getAge() % 2 != 0) {
            for (int i =0; i<100; i++) {
                userBio.getName();
                userBio.getAddress();
                userBio.getPhone();
                userBio.getAge();
                System.out.println("Data User ke-"+ i + ":\n" + userBio);
            }
        }
    }
}
