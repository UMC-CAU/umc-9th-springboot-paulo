package com.example.umc_9th_paulo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Umc9thPauloApplication {

    public static void main(String[] args) {
        SpringApplication.run(Umc9thPauloApplication.class, args);
    }

}
