package com.study.toby.section06.helloboot;

import com.study.toby.section06.config.EnableMyAutoConfiguration;
import com.study.toby.section06.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

@MySpringBootApplication
@EnableMyAutoConfiguration
public class TobyApplication {

    public static void main(String[] args) {
        SpringApplication.run(TobyApplication.class, args);
    }

}
