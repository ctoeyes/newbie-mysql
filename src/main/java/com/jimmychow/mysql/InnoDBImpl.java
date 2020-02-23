package com.jimmychow.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class InnoDBImpl implements InnoDB {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String A, Integer B, String C, Integer D) {
        jdbcTemplate.update("insert into INNODB(A, B, C, D ) values(?, ?, ?, ?)", A, B, C, D);
    }

    @Override
    public void retrieve(Integer D) {
        jdbcTemplate.queryForObject("select A from INNODB where D = ?", new Object[]{D}, String.class);
    }

    @Override
    public void retrieveByIndex(Integer B) {
        jdbcTemplate.queryForObject("select A from INNODB where B = ?", new Object[]{B}, String.class);
    }

    @Override
    public Integer getAll() {
        return jdbcTemplate.queryForObject("select count(1) from INNODB", Integer.class);
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.update("delete from INNODB");
    }
}