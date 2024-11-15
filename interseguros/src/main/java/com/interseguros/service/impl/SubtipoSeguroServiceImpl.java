package com.interseguros.service.impl;

import com.interseguros.model.SubtipoSeguro;
import com.interseguros.repo.ISubtipoSeguroRepo;
import com.interseguros.repo.IGenericRepo;
import com.interseguros.repo.IUbicacionRepo;
import com.interseguros.service.ISubtipoSeguroService;
import com.interseguros.service.IUbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubtipoSeguroServiceImpl extends CRUDImpl<SubtipoSeguro, Integer> implements ISubtipoSeguroService {

    @Autowired
    private ISubtipoSeguroRepo repo;

    @Override
    protected IGenericRepo<SubtipoSeguro, Integer> getRepo(){
        return repo;
    }

	@Override
	public List<SubtipoSeguro> obtenerSubtiposPorTipo(Integer tipoSeguro) {
		return repo.buscarTipoSeguro(tipoSeguro);
	}

	@Override
	public SubtipoSeguro descripSubtiposPorTipo(Integer subtipoSeguro) {
		return repo.descripTipoSeguro(subtipoSeguro);
	}

}
