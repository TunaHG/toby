package com.study.toby.section10.helloboot;

import org.springframework.stereotype.Service;

@Service
public class SimpleHelloService implements HelloService {
    private final MemberRepository memberRepository;

    public SimpleHelloService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public String sayHello(String name) {
        this.memberRepository.increaseCount(name);

        return "Hello, " + name + "!";
    }

    @Override
    public int countOf(String name) {
        return memberRepository.countOf(name);
    }
}
