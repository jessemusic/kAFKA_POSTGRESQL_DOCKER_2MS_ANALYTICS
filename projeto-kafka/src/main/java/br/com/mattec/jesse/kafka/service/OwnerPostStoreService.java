package br.com.mattec.jesse.kafka.service;

import dtos.OwnerPostDTO;

public interface OwnerPostStoreService {

    void createOwnerCar(OwnerPostDTO ownerPostDTO);

}
