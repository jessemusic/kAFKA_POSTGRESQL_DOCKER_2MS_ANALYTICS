package br.com.mattec.jesse.kafka.service;



import dtos.CarPostDTO;

import java.util.List;


public interface CarPostStoreService {

    List<CarPostDTO> getCarForSales();

    void changeCarForSale(CarPostDTO carPostDTO, String id);

    void removeCarForSale(String id);
}
