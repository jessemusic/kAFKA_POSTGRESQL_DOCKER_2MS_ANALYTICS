package br.com.mattec.jesse.analytics_service.repository;

import br.com.mattec.jesse.analytics_service.entity.CarModelPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPriceRepository extends JpaRepository<CarModelPriceEntity, Long> {
}
