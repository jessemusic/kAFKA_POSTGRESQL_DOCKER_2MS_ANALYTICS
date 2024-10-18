package br.com.mattec.jesse.kafka.controller;


import br.com.mattec.jesse.kafka.service.OwnerPostStoreService;
import dtos.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("owner")
public class OwnerPostController {

    @Autowired
    private OwnerPostStoreService ownerPostStoreService;

    @PostMapping
    public ResponseEntity createCarForSale(@RequestBody OwnerPostDTO ownerPostDTO){
        ownerPostStoreService.createOwnerCar(ownerPostDTO);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

}
