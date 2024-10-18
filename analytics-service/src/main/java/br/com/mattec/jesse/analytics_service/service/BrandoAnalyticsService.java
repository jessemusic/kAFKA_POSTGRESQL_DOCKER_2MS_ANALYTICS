package br.com.mattec.jesse.analytics_service.service;

import dtos.CarPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface BrandoAnalyticsService {

    void saveDataAnalytics(CarPostDTO carPostDTO);

}
