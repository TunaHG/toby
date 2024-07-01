package com.study.toby.section05;

import com.study.toby.section04.SimpleHelloService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloServiceTest {
    @Test
    void simpleHelloService() {
        SimpleHelloService helloService = new SimpleHelloService();

        String res = helloService.sayHello("Spring");

        assertThat(res).isEqualTo("Hello, Spring!");
    }
}
