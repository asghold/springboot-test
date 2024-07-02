package com.test.trupper.springboot_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.trupper.springboot_test.model.ClienteDto;
import com.test.trupper.springboot_test.service.ClienteService;



@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/create")
    public ResponseEntity<ClienteDto> create(@RequestBody ClienteDto entity) {
        try{
            ClienteDto clienteDto = clienteService.create(entity);
            return new ResponseEntity(clienteDto, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/createMultiple")
    public ResponseEntity<HttpStatus> createMultiple() {
        
        clienteService.createMultipleClients();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    

}
