package com.interseguros.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ubicacion")
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_ubicacion", nullable = false)
    private Long codUbicacion;

    @Column(name = "departamento", nullable = false)
    private String departamento;

    @Column(name = "municipio", nullable = false)
    private String municipio;

    public Ubicacion() {
    }

    public Ubicacion(String departamento, String municipio, Long codUbicacion) {
        this.departamento = departamento;
        this.municipio = municipio;
        this.codUbicacion = codUbicacion;
    }

    public Long getCodUbicacion() {
        return codUbicacion;
    }

    public void setCodUbicacion(Long codUbicacion) {
        this.codUbicacion = codUbicacion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}








