package com.interseguros.controller;

import com.interseguros.model.Cobertura;
import com.interseguros.service.ICoberturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cobertura")
public class CoberturaController {

    @Autowired
    private ICoberturaService service;

    //ResponseEntity Para capturar excepciones
    @GetMapping
    public ResponseEntity<List<Cobertura>> listar() throws Exception{
        List<Cobertura> lista=service.listar();
        return new ResponseEntity<List<Cobertura>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Cobertura listarPorId(@PathVariable("id") Integer id) throws Exception {
        return service.listarPorId(id);
    }

   //@RequestBody json a objeto  java
    @PostMapping
    public ResponseEntity<Cobertura> registrar( @RequestBody Cobertura Cobertura) throws Exception{
        Cobertura obj=service.registrar(Cobertura);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCobertura()).toUri();
        return new ResponseEntity<Cobertura>(obj, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Cobertura> modificar( @RequestBody Cobertura Cobertura) throws Exception{
        Cobertura obj=service.modificar(Cobertura);
        return new ResponseEntity<Cobertura>(obj, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
        Cobertura obj=service.listarPorId(id);
        if(obj==null) {
           // throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
