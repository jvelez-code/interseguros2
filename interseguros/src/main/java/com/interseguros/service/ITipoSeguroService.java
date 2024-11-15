package com.interseguros.service;

import com.interseguros.model.TipoSeguro;

import java.util.List;

public interface ITipoSeguroService extends ICRUD<TipoSeguro, Integer >{
    List<TipoSeguro> buscar();
}
