package br.com.mattec.jesse.analytics_service.message;


import br.com.mattec.jesse.analytics_service.service.BrandoAnalyticsService;
import dtos.CarPostDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static constants.JesseAPIsConstants.*;

@Log4j2
@Component
public class KafkaConsumerMessage {


    @Autowired
    private BrandoAnalyticsService brandoAnalyticsService;

    @KafkaListener(topics = KAFKA_TOPIC, groupId = KAFKA_GROUP_ID_ANALYTICS)
    public void listening(@Payload CarPostDTO carPostDTO){

        log.info("Receiving Car post information: {} ", carPostDTO);
        brandoAnalyticsService.saveDataAnalytics(carPostDTO);
    }



}
