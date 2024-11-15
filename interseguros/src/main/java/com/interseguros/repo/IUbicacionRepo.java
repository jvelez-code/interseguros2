package com.interseguros.repo;

import com.interseguros.model.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IUbicacionRepo extends IGenericRepo<Ubicacion, Integer> {
}
