package com.interseguros.controller;

import com.interseguros.dto.ParametroDTO;
import com.interseguros.model.SubtipoSeguro;
import com.interseguros.service.ISubtipoSeguroService;
import com.interseguros.service.IUbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/subtipoSeguros")
public class SubtipoSeguroController {

    @Autowired
    private ISubtipoSeguroService service;

    //ResponseEntity Para capturar excepciones
    @GetMapping
    public ResponseEntity<List<SubtipoSeguro>> listar() throws Exception{
        List<SubtipoSeguro> lista=service.listar();
        return new ResponseEntity<List<SubtipoSeguro>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public SubtipoSeguro listarPorId(@PathVariable("id") Integer id) throws Exception {
        return service.listarPorId(id);
    }

   //@RequestBody json a objeto  java
    @PostMapping
    public ResponseEntity<SubtipoSeguro> registrar( @RequestBody SubtipoSeguro SubtipoSeguro) throws Exception{
        SubtipoSeguro obj=service.registrar(SubtipoSeguro);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdSubtipoSeguro()).toUri();
        return new ResponseEntity<SubtipoSeguro>(obj, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<SubtipoSeguro> modificar( @RequestBody SubtipoSeguro SubtipoSeguro) throws Exception{
        SubtipoSeguro obj=service.modificar(SubtipoSeguro);
        return new ResponseEntity<SubtipoSeguro>(obj, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
        SubtipoSeguro obj=service.listarPorId(id);
        if(obj==null) {
           // throw new ModeloNotFoundException("ID NO ENCONTRADO: " +id);
        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    
    @PostMapping("/obtener")
    public List<SubtipoSeguro> obtenerSubtiposPorTipo(@RequestBody ParametroDTO parametroDTO) {
        Integer tipoSeguro = parametroDTO.getTipoSeguro();
        return service.obtenerSubtiposPorTipo(tipoSeguro);
    }
    
    @PostMapping("/obtenerDescrip")
    public SubtipoSeguro obtenerDescrip(@RequestBody ParametroDTO parametroDTO) {
        Integer subtipoSeguro = parametroDTO.getSubtipoSeguro();
        return service.descripSubtiposPorTipo(subtipoSeguro);
    }
}
