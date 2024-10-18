package br.com.mattec.jesse.kafka.client;

import constants.JesseAPIsConstants;
import dtos.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static constants.JesseAPIsConstants.USER_STORE_SERVICE_URI;


@Component
public class OwnerPostStoreClient {

    @Autowired
    RestTemplate restTemplate;

    public void ownerPostsClient(OwnerPostDTO newUser){
        restTemplate.postForEntity(USER_STORE_SERVICE_URI,newUser,OwnerPostDTO.class);
    }

}
