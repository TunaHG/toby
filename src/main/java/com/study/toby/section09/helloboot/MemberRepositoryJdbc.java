package com.study.toby.section09.helloboot;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryJdbc implements MemberRepository {
    private final JdbcTemplate jdbcTemplate;

    public MemberRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Member findMember(String name) {
        try {
            return jdbcTemplate.queryForObject(
                "SELECT * FROM member WHERE name = '" + name + "'",
                (rs, rowNum) -> new Member(rs.getString("name"), rs.getInt("count"))
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void increaseCount(String name) {
        Member member = findMember(name);
        if (member == null) jdbcTemplate.update("INSERT INTO member(name, count) VALUES(?, ?)", name, 1);
        else jdbcTemplate.update("UPDATE member SET count = ? WHERE name = ?", member.getCount() + 1, name);
    }
}
