package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class AlphaUserProducer {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    private final KafkaTemplate<String, UserBio> kafkaTemplate;

    @Autowired
    public AlphaUserProducer(KafkaTemplate<String, UserBio> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produceUserProfiles() {
        for (int i = 0; i < 100; i++) {
            UserBio userBio = generateRandomUserProfile();
            kafkaTemplate.send("yunrizal", userBio);
        }
    }

    private UserBio generateRandomUserProfile() {

        UserBio userBio = new UserBio();
        userBio.setName("Yunrizal");
        userBio.setAddress("Sukabumi");
        userBio.setPhone("0882938457759");
        userBio.setAge((int) (Math.random() * 100)); // Random age

        return userBio;
    }
}
