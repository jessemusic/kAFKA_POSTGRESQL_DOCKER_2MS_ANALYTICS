package br.com.mattec.jesse.store.service_car.service.impl;


import br.com.mattec.jesse.store.service_car.entity.OwnerPostEntity;
import br.com.mattec.jesse.store.service_car.repository.OwnerPostRepository;
import br.com.mattec.jesse.store.service_car.service.OwnerPostService;
import br.com.mattec.jesse.store.service_car.service.mapper.OwnerPostMapper;
import dtos.OwnerPostDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Autowired
    private OwnerPostMapper ownerPostMapper;


    @Override
    public void createOwner(OwnerPostDTO ownerPostDTO) {
        OwnerPostEntity ownerPostEntity = new OwnerPostEntity();
        BeanUtils.copyProperties(ownerPostDTO, ownerPostEntity);
        ownerPostRepository.save(ownerPostEntity);
    }
}
