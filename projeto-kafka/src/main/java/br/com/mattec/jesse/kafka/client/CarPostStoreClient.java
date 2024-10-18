package br.com.mattec.jesse.kafka.client;


import constants.JesseAPIsConstants;
import dtos.CarPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static constants.JesseAPIsConstants.POSTS_STORE_SERVICE_URI_CAR;
import static constants.JesseAPIsConstants.POSTS_STORE_SERVICE_URI_CARS;


@Component
public class CarPostStoreClient {

    @Autowired
    RestTemplate restTemplate;


    public List<CarPostDTO> carForSaleClient(){
        ResponseEntity<CarPostDTO[]> responseEntity = restTemplate.getForEntity(POSTS_STORE_SERVICE_URI_CARS, CarPostDTO[].class);
        return Arrays.asList(Objects.requireNonNull((responseEntity.getBody())));
    }

    public void changeCarForSaleClient(CarPostDTO carPostDTO, String id){
        restTemplate.put(POSTS_STORE_SERVICE_URI_CAR + id, carPostDTO,CarPostDTO.class);
    }

    public void deleteCarForSaleClient(String id){
        restTemplate.delete(POSTS_STORE_SERVICE_URI_CAR + id);
    }

}
