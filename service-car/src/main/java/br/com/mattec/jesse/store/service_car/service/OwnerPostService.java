package br.com.mattec.jesse.store.service_car.service;


import dtos.OwnerPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {

    void createOwner(OwnerPostDTO ownerPostDTO);

}
