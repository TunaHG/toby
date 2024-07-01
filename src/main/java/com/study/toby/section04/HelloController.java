package com.study.toby.section04;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloController {
    private final HelloService service;
    private final ApplicationContext applicationContext;

    public HelloController(HelloService service, ApplicationContext applicationContext) {
        this.service = service;
        this.applicationContext = applicationContext;

        System.out.println("Application context: " + applicationContext);
    }

    @GetMapping("/hello")
    public String hello(String name) {
        return service.sayHello(Objects.requireNonNull(name));
    }
}