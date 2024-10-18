package br.com.mattec.jesse.store.service_car.controller;

import br.com.mattec.jesse.store.service_car.service.CarPostService;
import dtos.CarPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sales")
public class CarPostController {

    @Autowired
    CarPostService carPostService;

    @GetMapping("/cars")
    public ResponseEntity<List<CarPostDTO>> getAllCarSales(){
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostService.getCarSales());
    }

    @PutMapping("/car/{id}")
    public ResponseEntity<CarPostDTO> updateCarSale(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") String id){
        carPostService.changeCarSale(carPostDTO, Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<Void> deleteCarSale(@PathVariable("id") String id){
        carPostService.removeCarSale(Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
