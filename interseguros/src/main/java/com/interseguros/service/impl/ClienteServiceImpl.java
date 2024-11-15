package com.interseguros.service.impl;

import com.interseguros.model.Cliente;
import com.interseguros.repo.IClienteRepo;
import com.interseguros.repo.IGenericRepo;
import com.interseguros.repo.IUbicacionRepo;
import com.interseguros.service.IClienteService;
import com.interseguros.service.IUbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl extends CRUDImpl<Cliente, Integer> implements IClienteService {

    @Autowired
    private IClienteRepo repo;

    @Override
    protected IGenericRepo<Cliente, Integer> getRepo(){
        return repo;
    }

}
