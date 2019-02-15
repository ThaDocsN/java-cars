package com.thadocizn.cars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarsApplication {

    public static final String EXCHANGE_NAME = "cars";
    public static final String QUEUE_NAME = "queue";

    public static void main(String[] args) {
        SpringApplication.run(CarsApplication.class, args);
    }

}

