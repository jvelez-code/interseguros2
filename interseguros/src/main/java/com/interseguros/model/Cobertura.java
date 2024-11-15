package com.interseguros.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "coberturas")
public class Cobertura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cobertura", nullable = false)
    private Long idCobertura;

    @ManyToOne
    @JoinColumn(name = "cod_poliza", nullable = false, foreignKey =  @ForeignKey(name = "fk_cobertura_poliza"))
    private DatosPoliza datosPoliza;

    @Column(name = "nombre_cobertura", nullable = false)
    private String nombreCobertura;

    @Column(name = "monto_cobertura", nullable = false)
    private BigDecimal montoCobertura;

    @Column(name = "descripcion")
    private String descripcion;
    
    public Cobertura() {
    }

    public Long getIdCobertura() {
        return idCobertura;
    }

    public Cobertura(Long idCobertura, String restricciones, String descripcion, BigDecimal montoCobertura, String nombreCobertura, DatosPoliza datosPoliza) {
        this.idCobertura = idCobertura;
        this.descripcion = descripcion;
        this.montoCobertura = montoCobertura;
        this.nombreCobertura = nombreCobertura;
        this.datosPoliza = datosPoliza;
    }

    public void setIdCobertura(Long idCobertura) {
        this.idCobertura = idCobertura;
    }

    public DatosPoliza getDatosPoliza() {
        return datosPoliza;
    }

    public void setDatosPoliza(DatosPoliza datosPoliza) {
        this.datosPoliza = datosPoliza;
    }

    public String getNombreCobertura() {
        return nombreCobertura;
    }

    public void setNombreCobertura(String nombreCobertura) {
        this.nombreCobertura = nombreCobertura;
    }

    public BigDecimal getMontoCobertura() {
        return montoCobertura;
    }

    public void setMontoCobertura(BigDecimal montoCobertura) {
        this.montoCobertura = montoCobertura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
