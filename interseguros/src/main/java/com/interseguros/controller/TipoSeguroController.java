package com.interseguros.controller;

import com.interseguros.model.TipoSeguro;
import com.interseguros.service.ITipoSeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tipoSeguros")
public class TipoSeguroController {

    @Autowired
    private ITipoSeguroService service;

    //ResponseEntity Para capturar excepciones
    @GetMapping
    public ResponseEntity<List<TipoSeguro>> listar() throws Exception{
        List<TipoSeguro> lista=service.listar();
        return new ResponseEntity<List<TipoSeguro>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TipoSeguro listarPorId(@PathVariable("id") Integer id) throws Exception {
        return service.listarPorId(id);
    }

   //@RequestBody json a objeto  java
    @PostMapping
    public ResponseEntity<TipoSeguro> registrar( @RequestBody TipoSeguro TipoSeguro) throws Exception{
        TipoSeguro obj=service.registrar(TipoSeguro);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipoSeguro()).toUri();
        return new ResponseEntity<TipoSeguro>(obj, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<TipoSeguro> modificar( @RequestBody TipoSeguro TipoSeguro) throws Exception{
        TipoSeguro obj=service.modificar(TipoSeguro);
        return new ResponseEntity<TipoSeguro>(obj, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
        TipoSeguro obj=service.listarPorId(id);
        if(obj==null) {
           // throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
