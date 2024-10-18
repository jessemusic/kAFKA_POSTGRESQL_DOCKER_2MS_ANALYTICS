package br.com.mattec.jesse.kafka.service.impl;

import br.com.mattec.jesse.kafka.client.OwnerPostStoreClient;
import dtos.OwnerPostDTO;
import br.com.mattec.jesse.kafka.service.OwnerPostStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostStoreServiceImpl implements OwnerPostStoreService {

    @Autowired
    private OwnerPostStoreClient ownerPostStoreClient;

    @Override
    public void createOwnerCar(OwnerPostDTO ownerPostDTO) {
        ownerPostStoreClient.ownerPostsClient(ownerPostDTO);
    }
}
