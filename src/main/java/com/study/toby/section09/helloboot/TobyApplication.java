package com.study.toby.section09.helloboot;

import com.study.toby.section09.config.MySpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MySpringBootApplication
public class TobyApplication {

    @Bean
    ApplicationRunner applicationRunner(Environment env) {
        return args -> {
            String name = env.getProperty("my.name");
            System.out.println("my.name: " + name);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(TobyApplication.class, args);
    }

}
