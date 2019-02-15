package com.thadocizn.cars;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarMessageListener {

    @RabbitListener
    public void receiveMessage(CarMessage carMessage){
        log.info("Received Message: {} ", carMessage.toString());
    }
}
