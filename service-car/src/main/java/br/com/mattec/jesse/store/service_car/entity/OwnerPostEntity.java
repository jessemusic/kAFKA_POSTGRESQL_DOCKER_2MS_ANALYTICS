package br.com.mattec.jesse.store.service_car.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "owner_post")
public class OwnerPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "owner_name")
    private String name;

    @Column(name = "owner_type")
    private String type;

    @Column(name = "owner_contact_number")
    private String contactNumber;


}
