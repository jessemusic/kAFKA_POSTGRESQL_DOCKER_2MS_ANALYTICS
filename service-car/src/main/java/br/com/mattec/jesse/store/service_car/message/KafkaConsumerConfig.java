package br.com.mattec.jesse.store.service_car.message;

import dtos.CarPostDTO;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

import static constants.JesseAPIsConstants.KAFKA_GROUP_ID_STORE;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;

    @Bean
    public ConsumerFactory<String, CarPostDTO> consumerFactory(){

        Map<String, Object> configProperties = new HashMap<>();

        configProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        configProperties.put(ConsumerConfig.GROUP_ID_CONFIG, KAFKA_GROUP_ID_STORE);
        configProperties.put(JsonDeserializer.TRUSTED_PACKAGES,"*");
        configProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(configProperties, new StringDeserializer(),
                new JsonDeserializer<>(CarPostDTO.class,false));

    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, CarPostDTO> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, CarPostDTO>
                factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}
