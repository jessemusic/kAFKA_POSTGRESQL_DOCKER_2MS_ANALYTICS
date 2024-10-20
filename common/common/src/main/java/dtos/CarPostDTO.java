package dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class CarPostDTO {

    private String model;
    private String brand;
    private Double price;
    private String description;
    private String engineVersion;
    private String city;
    private String createDate;
    private Long   ownerId;
    private String ownerName;
    private String ownertype;
    private String contact;

}
