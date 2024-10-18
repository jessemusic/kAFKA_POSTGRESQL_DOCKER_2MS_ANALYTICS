package br.com.mattec.jesse.store.service_car.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car_post")
public class CarPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "car_model")
    private String model;

    @Column(name = "car_brand")
    private String brand;

    @Column(name = "car_price")
    private Double price;

    @Column(name = "car_description")
    private String description;

    @Column(name = "car_engineVersion")
    private String engineVersion;

    @Column(name = "car_city")
    private String city;

    @Column(name = "car_createDate")
    private LocalDateTime createDate = LocalDateTime.now();

    @Column(name = "car_ownerId")
    private Long   ownerId;

    @Column(name = "car_ownerName")
    private String ownerName;

    @Column(name = "car_ownertype")
    private String ownertype;

    @Column(name = "car_contact")
    private String contact;

    @ManyToOne
    @JoinColumn(name = "Owner_post_id",nullable = false, referencedColumnName = "id")
    private OwnerPostEntity ownerPost;

}
