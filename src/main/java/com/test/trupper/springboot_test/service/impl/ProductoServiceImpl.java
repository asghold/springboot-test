package com.test.trupper.springboot_test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.trupper.springboot_test.entities.Producto;
import com.test.trupper.springboot_test.repository.ProductoRepository;
import com.test.trupper.springboot_test.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public void createMultipleProductos() {
        for(int i=1; i<= 50000; i++){
            Producto producto = new Producto();
            producto.setActivo(true);
            producto.setClave("Producto"+i);
            producto.setDescripcion("Producto de tipo: "+1);

            productoRepository.save(producto);
        }
        
        
    }

    
    

}
