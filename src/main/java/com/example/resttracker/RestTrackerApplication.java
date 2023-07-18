package com.example.resttracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestTrackerApplication implements CommandLineRunner {


    @Value("${server.port}")
    private String serverPort;

    public static void main(String[] args) {
        SpringApplication.run(RestTrackerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {



        System.out.println(" http://localhost:"+ serverPort + "/swagger-ui/index.html ");


    }

}
