package br.com.mattec.jesse.kafka.message;

import dtos.CarPostDTO;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfiguration {

    @Value("${spring.kafka.bootstrap-server}")
    private String bootstrapServer;

    @Bean
    public ProducerFactory<String, CarPostDTO> userProducerFactory(){

        Map<String, Object> configProperties = new HashMap<>();

        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        configProperties.put(JsonSerializer.ADD_TYPE_INFO_HEADERS,false);
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());

        return new DefaultKafkaProducerFactory<>(configProperties);

    }

    @Bean
    public KafkaTemplate<String, CarPostDTO> userKafkaTemplate(){
        return new KafkaTemplate<>(userProducerFactory());
    }


}
