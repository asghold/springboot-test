package com.test.trupper.springboot_test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.trupper.springboot_test.entities.Cliente;
import com.test.trupper.springboot_test.model.ClienteDto;
import com.test.trupper.springboot_test.repository.ClienteRepository;
import com.test.trupper.springboot_test.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{


    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteDto create(ClienteDto clienteDto) throws Exception {
        Cliente cliente = new Cliente();
        try{
            if(clienteDto != null){
                cliente.setActivo(true);
                cliente.setNombre("cliente");
                clienteRepository.save(cliente);
                
            }

        }catch(Exception e){
            throw new Exception("El cliente existe");
        }
        return clienteDto;
        
    }

    public void createMultipleClients(){
        for(int i=1; i<=100000; i++){
            Cliente cliente = new Cliente();

            cliente.setActivo(true);
            cliente.setNombre("Cliente"+i);

            clienteRepository.save(cliente);

        }
    }



}
