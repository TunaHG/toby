package com.study.toby.section06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@MySpringBootApplication
public class TobyApplication {

    public static void main(String[] args) {
        SpringApplication.run(TobyApplication.class, args);
    }

}
