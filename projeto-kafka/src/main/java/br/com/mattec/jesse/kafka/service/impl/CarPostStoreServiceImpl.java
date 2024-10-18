package br.com.mattec.jesse.kafka.service.impl;

import br.com.mattec.jesse.kafka.client.CarPostStoreClient;
import br.com.mattec.jesse.kafka.service.CarPostStoreService;
import dtos.CarPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarPostStoreServiceImpl implements CarPostStoreService {

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    @Override
    public List<CarPostDTO> getCarForSales() {
        return carPostStoreClient.carForSaleClient();
    }

    @Override
    public void changeCarForSale(CarPostDTO carPostDTO, String id) {
        carPostStoreClient.changeCarForSaleClient(carPostDTO,id);
    }

    @Override
    public void removeCarForSale(String id) {
        carPostStoreClient.deleteCarForSaleClient(id);
    }
}
