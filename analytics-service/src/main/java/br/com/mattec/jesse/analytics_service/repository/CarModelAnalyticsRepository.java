package br.com.mattec.jesse.analytics_service.repository;

import br.com.mattec.jesse.analytics_service.entity.CarModelAnalyticsEntity;
import br.com.mattec.jesse.analytics_service.entity.CarModelPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarModelAnalyticsRepository extends JpaRepository<CarModelAnalyticsEntity, Long> {
    Optional<CarModelAnalyticsEntity> findByModel(String model);
}
