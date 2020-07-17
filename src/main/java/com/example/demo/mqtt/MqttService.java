package com.example.demo.mqtt;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.Payloads;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;


@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttService {

    /**
     * payload进行消息发送
     */
    void sendToMqtt(String payload);

    /**
     * 指定topic进行消息发送
     */
    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, String payload);

    /**
     * 指定topic , qos进行消息发送
     */
    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos, String payload);
}