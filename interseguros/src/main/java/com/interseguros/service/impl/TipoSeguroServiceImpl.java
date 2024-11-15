package com.interseguros.service.impl;

import com.interseguros.model.TipoSeguro;
import com.interseguros.repo.ITipoSeguroRepo;
import com.interseguros.repo.IGenericRepo;
import com.interseguros.repo.IUbicacionRepo;
import com.interseguros.service.ITipoSeguroService;
import com.interseguros.service.IUbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoSeguroServiceImpl extends CRUDImpl<TipoSeguro, Integer> implements ITipoSeguroService {

    @Autowired
    private ITipoSeguroRepo repo;

    @Override
    protected IGenericRepo<TipoSeguro, Integer> getRepo(){
        return repo;
    }

	@Override
	public List<TipoSeguro> buscar() {
		// TODO Auto-generated method stub
		return null;
	}

}
