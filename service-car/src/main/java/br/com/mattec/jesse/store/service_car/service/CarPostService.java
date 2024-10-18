package br.com.mattec.jesse.store.service_car.service;



import dtos.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CarPostService {

    void newPostDetails(CarPostDTO carPostDTO);

    List<CarPostDTO> getCarSales();

    void changeCarSale(CarPostDTO carPostDTO, Long postId);

    void removeCarSale(Long postId);


}
