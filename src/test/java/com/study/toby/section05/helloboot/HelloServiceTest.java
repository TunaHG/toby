package com.study.toby.section05.helloboot;

import com.study.toby.section05.HelloDecorator;
import com.study.toby.section05.SimpleHelloService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloServiceTest {
    @Test
    void simpleHelloService() {
        SimpleHelloService helloService = new SimpleHelloService();

        String res = helloService.sayHello("Spring");

        assertThat(res).isEqualTo("Hello, Spring!");
    }

    @Test
    void helloDecorator() {
        HelloDecorator decorator = new HelloDecorator(name -> name);

        String res = decorator.sayHello("Spring");

        assertThat(res).isEqualTo("*Spring*");
    }
}
