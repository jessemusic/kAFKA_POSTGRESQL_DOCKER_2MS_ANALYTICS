package br.com.mattec.jesse.store.service_car.service.mapper;

import br.com.mattec.jesse.store.service_car.entity.OwnerPostEntity;
import dtos.OwnerPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OwnerPostMapper {

    OwnerPostEntity fromDtoToEntity(OwnerPostDTO ownerPostDTO);

    OwnerPostDTO fromEntityToDto (OwnerPostEntity ownerPostEntity);

}
