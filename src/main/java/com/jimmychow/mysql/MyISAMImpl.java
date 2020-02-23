package com.jimmychow.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyISAMImpl implements MyISAM{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String A, Integer B, String C, Integer D) {
        jdbcTemplate.update("insert into MYISAM(A, B, C, D ) values(?, ?, ?, ?)", A, B, C, D);
    }

    @Override
    public void retrieve(Integer D) {
        jdbcTemplate.queryForObject("select A from MYISAM where D = ?", new Object[]{D}, String.class);
    }

    @Override
    public void retrieveByIndex(Integer B) {
        jdbcTemplate.queryForObject("select A from MYISAM where B = ?", new Object[]{B}, String.class);
    }

    @Override
    public Integer getAll() {
        return jdbcTemplate.queryForObject("select count(1) from MYISAM", Integer.class);
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.update("delete from MYISAM");
    }
}
