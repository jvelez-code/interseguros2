package com.interseguros.controller;

import com.interseguros.model.DatosPoliza;
import com.interseguros.service.IDatosPolizaService;
import com.interseguros.service.IUbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/datosPolizas")
public class DatosPolizaController {

    @Autowired
    private IDatosPolizaService service;

    //ResponseEntity Para capturar excepciones
    @GetMapping
    public ResponseEntity<List<DatosPoliza>> listar() throws Exception{
        List<DatosPoliza> lista=service.listar();
        return new ResponseEntity<List<DatosPoliza>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DatosPoliza listarPorId(@PathVariable("id") Integer id) throws Exception {
        return service.listarPorId(id);
    }

   //@RequestBody json a objeto  java
    @PostMapping
    public ResponseEntity<DatosPoliza> registrar( @RequestBody DatosPoliza DatosPoliza) throws Exception{
        DatosPoliza obj=service.registrar(DatosPoliza);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCliente()).toUri();
        return new ResponseEntity<DatosPoliza>(obj, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<DatosPoliza> modificar( @RequestBody DatosPoliza DatosPoliza) throws Exception{
        DatosPoliza obj=service.modificar(DatosPoliza);
        return new ResponseEntity<DatosPoliza>(obj, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
        DatosPoliza obj=service.listarPorId(id);
        if(obj==null) {
           // throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
