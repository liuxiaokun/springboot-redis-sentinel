package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("demo")
@Slf4j
public class DemoController {

    @GetMapping("/test")
    public String test() {
        return "success";
    }

    @GetMapping("/test/oom")
    public void oom() {

        List<String> list = new ArrayList<>();
        while(true) {
            log.info("ASDFJLKSJFKLJSKFJKLAJKLFDSAJKLF");
            list.add("ASDFJLKSJFKLJSKFJKLAJKLFDSAJKLF");
        }
    }
}
