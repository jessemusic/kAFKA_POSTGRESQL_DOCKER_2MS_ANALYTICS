package br.com.mattec.jesse.store.service_car.service.impl;


import br.com.mattec.jesse.store.service_car.entity.CarPostEntity;
import br.com.mattec.jesse.store.service_car.repository.CarPostRepository;
import br.com.mattec.jesse.store.service_car.repository.OwnerPostRepository;
import br.com.mattec.jesse.store.service_car.service.CarPostService;
import br.com.mattec.jesse.store.service_car.service.mapper.CarPostMapper;
import dtos.CarPostDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarPostServiceImpl implements CarPostService {

    @Autowired
    private CarPostRepository carPostRepository;

    @Autowired
    private OwnerPostRepository ownerPostRepository;


    @Autowired
    private CarPostMapper carPostMapper;

    @Override
    public void newPostDetails(CarPostDTO carPostDTO) {
        CarPostEntity carPostEntity = new CarPostEntity();

        ownerPostRepository.findById(carPostDTO.getOwnerId()).ifPresentOrElse(car -> {
            carPostEntity.setOwnerPost(car);
            carPostEntity.setContact(car.getContactNumber());
        }, () ->{
            throw new RuntimeException("Usuário não adiciondo , erro no sistema!");
        });

        BeanUtils.copyProperties(carPostDTO,carPostEntity );
        carPostRepository.save(carPostEntity);

    }

    @Override
    public List<CarPostDTO> getCarSales() {
        List<CarPostDTO> listCarsSales = new ArrayList<>();
        carPostRepository.findAll().forEach(car -> {
            listCarsSales.add(carPostMapper.fromCarEntityToDto(car));
        });
        return listCarsSales;
    }

    @Override
    public void changeCarSale(CarPostDTO carPostDTO, Long postId) {
        carPostRepository.findById(postId).ifPresentOrElse(car ->{
            car.setDescription(carPostDTO.getDescription());
            car.setContact(carPostDTO.getContact());
            car.setPrice(carPostDTO.getPrice());
            car.setBrand(carPostDTO.getBrand());
            car.setEngineVersion(carPostDTO.getEngineVersion());
            car.setModel(carPostDTO.getModel());
            carPostRepository.save(car);
        }, () ->{
                throw new NoSuchElementException(" Não há car no banco de dados!");
        });
    }

    @Override
    public void removeCarSale(Long postId) {
        carPostRepository.deleteById(postId);
    }
}
