package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class AlphaUserProducer {
    private static final String TOPIC = "user-profiles";
    private static final int MINIMUM_PROFILES = 1000;

    private final KafkaTemplate<String, UserBio> kafkaTemplate;

    @Autowired
    public AlphaUserProducer(KafkaTemplate<String, UserBio> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produceUserProfiles() {
        for (int i = 0; i < MINIMUM_PROFILES; i++) {
            UserBio userBio = generateRandomUserProfile();
            kafkaTemplate.send(TOPIC, userBio);
        }
    }

    private UserBio generateRandomUserProfile() {
        // Logic to generate a random user profile
        // Example:
        UserBio userBio = new UserBio();
        userBio.setName("User1");
        userBio.setAddress("Bandung");
        userBio.setPhone("0882938457759");
        userBio.setAge((int) (Math.random() * 100)); // Random age

        return userBio;
    }
}
