package br.com.mattec.jesse.analytics_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car_model_analytics")
public class CarModelAnalyticsEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String model;

    private Long posts;

}
