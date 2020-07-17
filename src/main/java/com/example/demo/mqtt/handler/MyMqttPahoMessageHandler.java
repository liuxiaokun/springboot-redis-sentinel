package com.example.demo.mqtt.handler;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;

@Slf4j
public class MyMqttPahoMessageHandler extends MqttPahoMessageHandler {

    public MyMqttPahoMessageHandler(String url, String clientId, MqttPahoClientFactory clientFactory) {
        super(url, clientId, clientFactory);
    }

    public MyMqttPahoMessageHandler(String clientId, MqttPahoClientFactory clientFactory) {
        super(clientId, clientFactory);
    }

    public MyMqttPahoMessageHandler(String url, String clientId) {
        super(url, clientId);
    }

    @Override
    public synchronized void connectionLost(Throwable cause) {
        log.info("connectionLost");
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) {
        log.info("messageArrived");
        super.messageArrived(topic, message);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        log.info("deliveryComplete");
        super.deliveryComplete(token);
    }
}
