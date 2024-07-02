package com.test.trupper.springboot_test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.trupper.springboot_test.service.ProductoService;


@RestController
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/createMultipleProducts")
    public ResponseEntity<HttpStatus> createMultipleProducts() {
        
        productoService.createMultipleProductos();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
