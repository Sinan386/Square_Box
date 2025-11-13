package com.example.squaregames;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;


@Service
public class RandomHeartBeat implements HeartbeatSensor {

    private final SecureRandom random = new SecureRandom();

    @Override
    public int get() {
        return random.nextInt();
    }

}
