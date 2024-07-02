package com.test.trupper.springboot_test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.trupper.springboot_test.model.ComprasDto;
import com.test.trupper.springboot_test.model.DetalleDto;
import com.test.trupper.springboot_test.service.ComprasService;



@RestController
@RequestMapping("/api")
public class ComprasController {

    @Autowired
    private ComprasService comprasService;

    @PostMapping("/registra-compra")
    public ResponseEntity<ComprasDto> registracompra(@RequestBody ComprasDto lista) throws NotFoundException{
        ComprasDto compras = comprasService.resistraCompra(lista);
        return new ResponseEntity<ComprasDto>(compras, HttpStatus.OK);

    }

    @GetMapping("/obtener-compras/{idCliente}")
    public ResponseEntity<List<ComprasDto>> getMethodName(@PathVariable Integer idCliente) throws NotFoundException{
        List<ComprasDto> compras = comprasService.obtenerCompras(idCliente);
        return new ResponseEntity<List<ComprasDto>>(compras, HttpStatus.OK);
    }

    @PutMapping("/actualiza-compras/{id}")
    public ResponseEntity<ComprasDto> putMethodName(@PathVariable Integer id, @RequestBody List<DetalleDto> entity) {
        try{
            ComprasDto compras = comprasService.actualizaCompras(id,entity);
        
        return new ResponseEntity<ComprasDto>(compras, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/elimina-compra/{id}")
    public ResponseEntity<HttpStatus> eliminaCompra(@PathVariable Integer id){
        try{
            comprasService.eliminaCompra(id);
        
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    
}
