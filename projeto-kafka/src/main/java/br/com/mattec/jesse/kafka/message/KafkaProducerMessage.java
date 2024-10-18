package br.com.mattec.jesse.kafka.message;


import dtos.CarPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static constants.JesseAPIsConstants.KAFKA_TOPIC;


@Component
public class KafkaProducerMessage {

    @Autowired
    private KafkaTemplate<String, CarPostDTO> kafkaTemplate;

    public void sendMessage(CarPostDTO carPostDTO){
        kafkaTemplate.send(KAFKA_TOPIC, carPostDTO);
    }
}
