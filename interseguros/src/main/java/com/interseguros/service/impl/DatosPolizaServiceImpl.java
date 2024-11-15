package com.interseguros.service.impl;

import com.interseguros.model.DatosPoliza;
import com.interseguros.repo.IDatosPolizaRepo;
import com.interseguros.repo.IGenericRepo;
import com.interseguros.repo.IUbicacionRepo;
import com.interseguros.service.IDatosPolizaService;
import com.interseguros.service.IUbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatosPolizaServiceImpl extends CRUDImpl<DatosPoliza, Integer> implements IDatosPolizaService {

    @Autowired
    private IDatosPolizaRepo repo;

    @Override
    protected IGenericRepo<DatosPoliza, Integer> getRepo(){
        return repo;
    }

}
