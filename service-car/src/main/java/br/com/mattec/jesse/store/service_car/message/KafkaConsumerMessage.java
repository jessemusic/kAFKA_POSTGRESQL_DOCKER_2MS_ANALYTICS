package br.com.mattec.jesse.store.service_car.message;


import br.com.mattec.jesse.store.service_car.service.CarPostService;
import dtos.CarPostDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static constants.JesseAPIsConstants.KAFKA_GROUP_ID_STORE;
import static constants.JesseAPIsConstants.KAFKA_TOPIC;

@Log4j2
@Component
public class KafkaConsumerMessage {


    @Autowired
    private CarPostService carPostService;

    @KafkaListener(topics = KAFKA_TOPIC, groupId = KAFKA_GROUP_ID_STORE)
    public void listening(CarPostDTO carPostDTO){

        log.info("Receiving Car post information: {} ", carPostDTO);
        carPostService.newPostDetails(carPostDTO);
    }



}
