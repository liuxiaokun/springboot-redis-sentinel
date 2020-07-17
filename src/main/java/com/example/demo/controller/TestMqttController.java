package com.example.demo.controller;

import com.example.demo.mqtt.MqttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestMqttController {

    private final MqttService mqttService;

    public TestMqttController(MqttService mqttService) {
        this.mqttService = mqttService;
    }

    @GetMapping("/sendMq")
    public String sendMqtt(String sendData) {
        mqttService.sendToMqtt("testtopic/1", sendData);
        return "send success";
    }
}