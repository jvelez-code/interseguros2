package com.interseguros.service.impl;

import com.interseguros.model.CoberturaBeneficiario;
import com.interseguros.repo.ICoberturaBeneficiarioRepo;
import com.interseguros.repo.IGenericRepo;
import com.interseguros.repo.IUbicacionRepo;
import com.interseguros.service.ICoberturaBeneficiarioService;
import com.interseguros.service.IUbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoberturaBeneficiarioServiceImpl extends CRUDImpl<CoberturaBeneficiario, Integer> implements ICoberturaBeneficiarioService {

    @Autowired
    private ICoberturaBeneficiarioRepo repo;

    @Override
    protected IGenericRepo<CoberturaBeneficiario, Integer> getRepo(){
        return repo;
    }

}
