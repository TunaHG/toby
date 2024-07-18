package com.study.toby.section07.helloboot;

import com.study.toby.section07.config.EnableMyAutoConfiguration;
import com.study.toby.section07.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

@MySpringBootApplication
@EnableMyAutoConfiguration
public class TobyApplication {

    public static void main(String[] args) {
        SpringApplication.run(TobyApplication.class, args);
    }

}
