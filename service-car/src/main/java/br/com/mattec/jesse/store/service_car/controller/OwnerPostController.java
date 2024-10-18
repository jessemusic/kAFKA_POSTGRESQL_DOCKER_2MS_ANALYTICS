package br.com.mattec.jesse.store.service_car.controller;

import br.com.mattec.jesse.store.service_car.service.OwnerPostService;
import dtos.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class OwnerPostController {

    @Autowired
    private OwnerPostService ownerPostService;


    @PostMapping
    public ResponseEntity<OwnerPostDTO> createOwner(@RequestBody OwnerPostDTO ownerPostDTO){
        ownerPostService.createOwner(ownerPostDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}
