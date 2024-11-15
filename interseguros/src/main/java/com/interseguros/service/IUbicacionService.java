package com.interseguros.service;

import com.interseguros.model.Ubicacion;

import java.util.List;

public interface IUbicacionService extends ICRUD<Ubicacion, Integer >{
    List<Ubicacion> buscar();
}
