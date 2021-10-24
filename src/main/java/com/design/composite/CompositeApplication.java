package com.design.composite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class CompositeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompositeApplication.class, args);
    }

}
