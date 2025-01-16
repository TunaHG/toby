package com.study.toby.section10.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class HelloServiceCountTest {
    @Autowired
    HelloService helloService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void sayHelloIncreaseCount() {
        String name = "Toby";

        // helloService.sayHello(name);
        // assertThat(memberRepository.countOf(name)).isEqualTo(1);
        //
        // helloService.sayHello(name);
        // assertThat(memberRepository.countOf(name)).isEqualTo(2);

        IntStream.rangeClosed(1, 10).forEach(count -> {
            helloService.sayHello(name);
            assertThat(memberRepository.countOf(name)).isEqualTo(count);
        });
    }
}
