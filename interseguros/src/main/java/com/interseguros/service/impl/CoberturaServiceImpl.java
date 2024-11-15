package com.interseguros.service.impl;

import com.interseguros.model.Cobertura;
import com.interseguros.repo.ICoberturaRepo;
import com.interseguros.repo.IGenericRepo;
import com.interseguros.repo.IUbicacionRepo;
import com.interseguros.service.ICoberturaService;
import com.interseguros.service.IUbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoberturaServiceImpl extends CRUDImpl<Cobertura, Integer> implements ICoberturaService {

    @Autowired
    private ICoberturaRepo repo;

    @Override
    protected IGenericRepo<Cobertura, Integer> getRepo(){
        return repo;
    }

}
