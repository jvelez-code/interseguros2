package com.interseguros.repo;

import com.interseguros.model.SubtipoSeguro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ISubtipoSeguroRepo extends IGenericRepo<SubtipoSeguro, Integer> {
	
	@Query("SELECT s FROM SubtipoSeguro s WHERE s.tipoSeguro.idTipoSeguro = :tipoSeguro")
    List<SubtipoSeguro> buscarTipoSeguro(Integer tipoSeguro);
	
	@Query("SELECT s FROM SubtipoSeguro s WHERE s.idSubtipoSeguro = :subtipoSeguro")
	SubtipoSeguro descripTipoSeguro(Integer subtipoSeguro);
	
	
}
