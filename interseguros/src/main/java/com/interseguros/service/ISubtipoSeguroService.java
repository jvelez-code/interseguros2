package com.interseguros.service;

import java.util.List;

import com.interseguros.model.SubtipoSeguro;

public interface ISubtipoSeguroService extends ICRUD<SubtipoSeguro, Integer >{
	
	List<SubtipoSeguro> obtenerSubtiposPorTipo(Integer tipoSeguro);
	SubtipoSeguro descripSubtiposPorTipo(Integer subtipoSeguro);
}
