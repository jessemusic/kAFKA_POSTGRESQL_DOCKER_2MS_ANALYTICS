package br.com.mattec.jesse.store.service_car.service.mapper;


import br.com.mattec.jesse.store.service_car.entity.CarPostEntity;
import dtos.CarPostDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarPostMapper {

    CarPostDTO fromCarEntityToDto(CarPostEntity carPostEntity);

    CarPostEntity fromCarDtoToEntity(CarPostDTO carPostDTO);

}
