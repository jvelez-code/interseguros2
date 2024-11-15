package com.interseguros.repo;

import com.interseguros.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepo extends IGenericRepo<Cliente, Integer> {
}
