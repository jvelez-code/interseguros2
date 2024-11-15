package com.interseguros.repo;

import com.interseguros.model.TipoSeguro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoSeguroRepo extends IGenericRepo<TipoSeguro, Integer> {
}
