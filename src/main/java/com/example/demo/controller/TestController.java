package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/test1")
@RestController
public class TestController {

    @Autowired
    @Qualifier("hadoopJdbcTemplate")
    private JdbcTemplate hadoopJdbcTemplate;

    @GetMapping("hadoop")
    public void test() {
        System.out.println("111111111111111");
        List<Map<String, Object>> maps = hadoopJdbcTemplate.queryForList("SELECT * FROM TEST_USER");
        maps.forEach(tem -> {
            tem.forEach((key, value) -> System.out.println(key + ":" + value));
        });
    }
}
