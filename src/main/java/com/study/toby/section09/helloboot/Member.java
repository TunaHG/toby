package com.study.toby.section09.helloboot;

public class Member {
    private String name;
    private int count;

    public Member(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
