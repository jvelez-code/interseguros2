package com.interseguros.service.impl;

import com.interseguros.repo.IGenericRepo;
import com.interseguros.service.ICRUD;

import java.util.List;

public abstract class CRUDImpl <T , ID> implements ICRUD<T , ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T registrar(T obj) throws Exception {
        return getRepo().save(obj);
    }

    @Override
    public T modificar(T obj) throws Exception {
        return getRepo().save(obj);
    }

    @Override
    public List<T> listar() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T listarPorId(ID id) throws Exception {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public void eliminar(ID id) throws Exception {
        getRepo().deleteById(id);
    }



}
