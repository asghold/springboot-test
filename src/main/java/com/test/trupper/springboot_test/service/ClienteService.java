package com.test.trupper.springboot_test.service;

import com.test.trupper.springboot_test.model.ClienteDto;

public interface ClienteService {

    ClienteDto create(ClienteDto clienteDto) throws Exception;

    void createMultipleClients();

}
