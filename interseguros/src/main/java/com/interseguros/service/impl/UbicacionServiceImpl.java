package com.interseguros.service.impl;

import com.interseguros.model.Ubicacion;
import com.interseguros.repo.IGenericRepo;
import com.interseguros.repo.IUbicacionRepo;
import com.interseguros.service.IUbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicacionServiceImpl extends CRUDImpl<Ubicacion, Integer> implements IUbicacionService {

    @Autowired
    private IUbicacionRepo repo;

    @Override
    protected IGenericRepo<Ubicacion, Integer> getRepo(){
        return repo;
    }

    @Override
    public List<Ubicacion> buscar() {
        return List.of();
    }
}
