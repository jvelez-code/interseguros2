package com.interseguros.controller;

import com.interseguros.model.Ubicacion;
import com.interseguros.service.IUbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ubicacion")
public class UbicacionController {

    @Autowired
    private IUbicacionService service;

    //ResponseEntity Para capturar excepciones
    @GetMapping
    public ResponseEntity<List<Ubicacion>> listar() throws Exception{
        List<Ubicacion> lista=service.listar();
        return new ResponseEntity<List<Ubicacion>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Ubicacion listarPorId(@PathVariable("id") Integer id) throws Exception {
        return service.listarPorId(id);
    }

   //@RequestBody json a objeto  java
    @PostMapping
    public ResponseEntity<Ubicacion> registrar( @RequestBody Ubicacion Ubicacion) throws Exception{
        Ubicacion obj=service.registrar(Ubicacion);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCodUbicacion()).toUri();
        return new ResponseEntity<Ubicacion>(obj, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Ubicacion> modificar( @RequestBody Ubicacion Ubicacion) throws Exception{
        Ubicacion obj=service.modificar(Ubicacion);
        return new ResponseEntity<Ubicacion>(obj, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
        Ubicacion obj=service.listarPorId(id);
        if(obj==null) {
           // throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
