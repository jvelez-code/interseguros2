package com.interseguros.controller;

import com.interseguros.model.CoberturaBeneficiario;
import com.interseguros.service.ICoberturaBeneficiarioService;
import com.interseguros.service.IUbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/coberturaBeneficiarios")
public class CoberturaBeneficiarioController {

    @Autowired
    private ICoberturaBeneficiarioService service;

    //ResponseEntity Para capturar excepciones
    @GetMapping
    public ResponseEntity<List<CoberturaBeneficiario>> listar() throws Exception{
        List<CoberturaBeneficiario> lista=service.listar();
        return new ResponseEntity<List<CoberturaBeneficiario>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public CoberturaBeneficiario listarPorId(@PathVariable("id") Integer id) throws Exception {
        return service.listarPorId(id);
    }

   //@RequestBody json a objeto  java
    @PostMapping
    public ResponseEntity<CoberturaBeneficiario> registrar( @RequestBody CoberturaBeneficiario CoberturaBeneficiario) throws Exception{
        CoberturaBeneficiario obj=service.registrar(CoberturaBeneficiario);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdBeneficiario()).toUri();
        return new ResponseEntity<CoberturaBeneficiario>(obj, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<CoberturaBeneficiario> modificar( @RequestBody CoberturaBeneficiario CoberturaBeneficiario) throws Exception{
        CoberturaBeneficiario obj=service.modificar(CoberturaBeneficiario);
        return new ResponseEntity<CoberturaBeneficiario>(obj, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
        CoberturaBeneficiario obj=service.listarPorId(id);
        if(obj==null) {
           // throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
