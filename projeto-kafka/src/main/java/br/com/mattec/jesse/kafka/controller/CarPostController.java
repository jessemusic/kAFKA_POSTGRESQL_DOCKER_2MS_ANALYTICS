package br.com.mattec.jesse.kafka.controller;

import br.com.mattec.jesse.kafka.service.CarPostStoreService;
import dtos.CarPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/car")
public class CarPostController {

    @Autowired
    private CarPostStoreService carPostStoreService;


    @GetMapping("/posts")
    public ResponseEntity<List<CarPostDTO>> getCarSales(){
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostStoreService.getCarForSales());
    }

    @PutMapping("/{id}")
    public ResponseEntity changeCarForSale(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") String id){
        carPostStoreService.changeCarForSale(carPostDTO,id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarForSale(@PathVariable("id") String id){
        carPostStoreService.removeCarForSale(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
