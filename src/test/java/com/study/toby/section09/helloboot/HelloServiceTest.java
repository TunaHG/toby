package com.study.toby.section09.helloboot;

import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.assertj.core.api.Assertions.assertThat;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@UnitTest
@interface FastUnitTest {

}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Test
@interface UnitTest {

}

public class HelloServiceTest {
    @UnitTest
    void simpleHelloService() {
        // SimpleHelloService helloService = new SimpleHelloService(getMemberRepository());
        SimpleHelloService helloService = new SimpleHelloService(memberRepository);

        String res = helloService.sayHello("Spring");

        assertThat(res).isEqualTo("Hello, Spring!");
    }

    @FastUnitTest
    void helloDecorator() {
        HelloDecorator decorator = new HelloDecorator(name -> name);

        String res = decorator.sayHello("Spring");

        assertThat(res).isEqualTo("*Spring*");
    }

    private static MemberRepository getMemberRepository() {
        return new MemberRepository() {
            @Override
            public Member findMember(String name) {
                return null;
            }

            @Override
            public void increaseCount(String name) {

            }
        };
    }

    private static MemberRepository memberRepository = new MemberRepository() {
        @Override
        public Member findMember(String name) {
            return null;
        }

        @Override
        public void increaseCount(String name) {

        }
    };
}
