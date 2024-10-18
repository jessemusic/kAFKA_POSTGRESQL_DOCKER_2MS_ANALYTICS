package br.com.mattec.jesse.analytics_service.repository;

import br.com.mattec.jesse.analytics_service.entity.BrandAnalyticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandAnalyticsRepository  extends JpaRepository<BrandAnalyticsEntity, Long> {
    Optional<BrandAnalyticsEntity> findByBrand(String brand);
}
