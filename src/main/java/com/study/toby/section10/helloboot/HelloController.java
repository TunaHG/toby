package com.study.toby.section10.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final HelloService service;

    public HelloController(HelloService service) {
        this.service = service;
    }

    // private final ApplicationContext applicationContext;
    //
    // public HelloController(HelloService service, ApplicationContext applicationContext) {
    //     this.service = service;
    //     this.applicationContext = applicationContext;
    //
    //     System.out.println("Application context: " + applicationContext);
    // }

    @GetMapping("/hello")
    public String hello(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }

        // return service.sayHello(Objects.requireNonNull(name));
        return service.sayHello(name);
    }

    @GetMapping("/count")
    public String count(String name) {
        return name + ": " + service.countOf(name);
    }
}
