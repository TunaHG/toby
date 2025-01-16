package com.study.toby.section10.helloboot;

import com.study.toby.section09.helloboot.Member;
import com.study.toby.section09.helloboot.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@HelloBootTest
public class MemberRepositoryTest {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    MemberRepository memberRepository;

    // @BeforeEach
    // void init() {
    //     jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS member(name varchar(50) PRIMARY KEY, count int)");
    // }

    @Test
    void findMemberFailed() {
        Member member = memberRepository.findMember("Toby");
        assertThat(member).isNull();
    }

    @Test
    void increaseCount() {
        String name = "Toby";
        assertThat(memberRepository.countOf(name)).isEqualTo(0);

        memberRepository.increaseCount(name);
        assertThat(memberRepository.countOf(name)).isEqualTo(1);

        memberRepository.increaseCount(name);
        assertThat(memberRepository.countOf(name)).isEqualTo(2);
    }
}
