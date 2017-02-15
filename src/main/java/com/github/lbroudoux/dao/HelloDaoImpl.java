package com.github.lbroudoux.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by mladen on 15.2.2017..
 */
@Component
public class HelloDaoImpl implements HelloDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String getTemplate() {
        int templateId = new Random().nextInt(3) + 1;
        return jdbcTemplate.queryForObject("select text from template where id = ?", new Object[]{templateId}, String.class);
    }
}
