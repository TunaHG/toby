package com.study.toby.section10.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@HelloBootTest
// @Rollback(false)
public class JdbcTemplateTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // @BeforeEach
    // void init() {
    //     jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS member(name varchar(50) PRIMARY KEY, count int)");
    // }

    @Test
    void insertAndQuery() {
        jdbcTemplate.update("INSERT INTO member(name, count) VALUES(?, ?)", "Toby", 3);
        jdbcTemplate.update("INSERT INTO member(name, count) VALUES(?, ?)", "Spring", 1);

        Long count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM member", Long.class);
        assertThat(count).isEqualTo(2);
    }

    @Test
    void insertAndQuery2() {
        jdbcTemplate.update("INSERT INTO member(name, count) VALUES(?, ?)", "Toby", 3);
        jdbcTemplate.update("INSERT INTO member(name, count) VALUES(?, ?)", "Spring", 1);

        Long count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM member", Long.class);
        assertThat(count).isEqualTo(2);
    }
}
