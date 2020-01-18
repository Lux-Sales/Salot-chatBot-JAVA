package com.salot.Salot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SalotApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalotApplication.class, args);
    }

}
