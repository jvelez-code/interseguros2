package com.interseguros.controller;

import com.interseguros.model.Cliente;
import com.interseguros.service.IClienteService;
import com.interseguros.service.IUbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService service;

    //ResponseEntity Para capturar excepciones
    @GetMapping
    public ResponseEntity<List<Cliente>> listar() throws Exception{
        List<Cliente> lista=service.listar();
        return new ResponseEntity<List<Cliente>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Cliente listarPorId(@PathVariable("id") Integer id) throws Exception {
        return service.listarPorId(id);
    }

   //@RequestBody json a objeto  java
    @PostMapping
    public ResponseEntity<Cliente> registrar( @RequestBody Cliente Cliente) throws Exception{
        Cliente obj=service.registrar(Cliente);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCedulaCliente()).toUri();
        return new ResponseEntity<Cliente>(obj, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Cliente> modificar( @RequestBody Cliente Cliente) throws Exception{
        Cliente obj=service.modificar(Cliente);
        return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
        Cliente obj=service.listarPorId(id);
        if(obj==null) {
           // throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
