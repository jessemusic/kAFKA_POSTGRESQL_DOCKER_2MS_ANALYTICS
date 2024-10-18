package br.com.mattec.jesse.store.service_car.repository;

import br.com.mattec.jesse.store.service_car.entity.CarPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPostRepository extends JpaRepository<CarPostEntity, Long> {
}
