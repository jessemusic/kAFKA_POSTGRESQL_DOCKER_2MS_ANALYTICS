package br.com.mattec.jesse.analytics_service.service.impl;

import br.com.mattec.jesse.analytics_service.entity.BrandAnalyticsEntity;
import br.com.mattec.jesse.analytics_service.entity.CarModelAnalyticsEntity;
import br.com.mattec.jesse.analytics_service.entity.CarModelPriceEntity;
import br.com.mattec.jesse.analytics_service.repository.BrandAnalyticsRepository;
import br.com.mattec.jesse.analytics_service.repository.CarModelAnalyticsRepository;
import br.com.mattec.jesse.analytics_service.repository.CarPriceRepository;
import br.com.mattec.jesse.analytics_service.service.BrandoAnalyticsService;
import dtos.CarPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandoAnalyticsServiceImpl implements BrandoAnalyticsService {

    @Autowired
    private BrandAnalyticsRepository brandAnalyticsRepository;

    @Autowired
    private CarModelAnalyticsRepository carModelAnalyticsRepository;

    @Autowired
    private CarPriceRepository carPriceRepository;


    @Override
    public void saveDataAnalytics(CarPostDTO carPostDTO) {

        saveBrandAnalytics(carPostDTO.getBrand());
        saveCarModelAnalytics(carPostDTO.getModel());
        saveCarModelPriceAnalytics(carPostDTO.getModel(), carPostDTO.getPrice());

    }

    private void saveBrandAnalytics(String brand) {

        BrandAnalyticsEntity brandAnalyticsEntity = new BrandAnalyticsEntity();

        brandAnalyticsRepository.findByBrand(brand).ifPresentOrElse(brandItem ->{
            brandItem.setPosts(brandItem.getPosts() + 1);
            brandAnalyticsRepository.save(brandItem);
        }, () -> {
            brandAnalyticsEntity.setBrand(brand);
            brandAnalyticsEntity.setPosts(1L);
            brandAnalyticsRepository.save(brandAnalyticsEntity);
        });

    }

    private void saveCarModelAnalytics(String carModel) {

        CarModelAnalyticsEntity carModelAnalyticsEntity = new CarModelAnalyticsEntity();

        carModelAnalyticsRepository.findByModel(carModel).ifPresentOrElse(carModelItem -> {
            carModelItem.setPosts(carModelItem.getPosts() + 1);
            carModelAnalyticsRepository.save(carModelItem);
        }, () -> {
            carModelAnalyticsEntity.setModel(carModel);
            carModelAnalyticsEntity.setPosts(1L);
            carModelAnalyticsRepository.save(carModelAnalyticsEntity);
        });
    }


    private void saveCarModelPriceAnalytics(String model, Double price) {

        CarModelPriceEntity carModelPriceEntity = new CarModelPriceEntity();

        carModelPriceEntity.setModel(model);
        carModelPriceEntity.setPrice(price);
        carPriceRepository.save(carModelPriceEntity);
    }

}
