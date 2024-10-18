package br.com.mattec.jesse.store.service_car.repository;

import br.com.mattec.jesse.store.service_car.entity.OwnerPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerPostRepository extends JpaRepository<OwnerPostEntity, Long> {
}
