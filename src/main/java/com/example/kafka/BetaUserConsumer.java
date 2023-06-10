package com.example.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class BetaUserConsumer {

    @KafkaListener(topics = "user-profiles", groupId = "beta-group")
    public void consumeUserProfile(@Payload UserBio userProfile) {
        if (userProfile.getAge() % 2 != 0) {
            System.out.println("User Profile: " + userProfile);
        }
    }
}
