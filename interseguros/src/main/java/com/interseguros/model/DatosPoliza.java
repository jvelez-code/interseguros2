package com.interseguros.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "datos_poliza")
public class DatosPoliza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_poliza", nullable = false)
    private Long codPoliza;

    @ManyToOne
    @JoinColumn(name = "cedula_cliente", nullable = false, foreignKey =  @ForeignKey(name = "fk_poliza_cliente"))
    private Cliente Cliente;

    @ManyToOne
    @JoinColumn(name = "id_subtiposeguro", nullable = false, foreignKey =  @ForeignKey(name = "fk_poliza_subtipo"))
    private SubtipoSeguro subtipoSeguro;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaInicial;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaFinal;

    @Column(name = "prima", nullable = false)
    private BigDecimal prima;
    
    @Column(name = "estado", nullable = false)
    private String estado;

    public DatosPoliza() {
    }

    public DatosPoliza(Long codPoliza, com.interseguros.model.Cliente cliente, SubtipoSeguro subtipoSeguro, LocalDateTime fechaInicial, LocalDateTime fechaFinal, BigDecimal montoAsegurado, BigDecimal prima, String exclusiones, String duracionMeses, String condicionesReclamacion, String estado) {
        this.codPoliza = codPoliza;
        Cliente = cliente;
        this.subtipoSeguro = subtipoSeguro;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.prima = prima;
        this.estado = estado;
    }

    public Long getCodPoliza() {
        return codPoliza;
    }

    public void setCodPoliza(Long codPoliza) {
        this.codPoliza = codPoliza;
    }

    public com.interseguros.model.Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(com.interseguros.model.Cliente cliente) {
        Cliente = cliente;
    }

    public SubtipoSeguro getSubtipoSeguro() {
        return subtipoSeguro;
    }

    public void setSubtipoSeguro(SubtipoSeguro subtipoSeguro) {
        this.subtipoSeguro = subtipoSeguro;
    }

    public LocalDateTime getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDateTime fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public LocalDateTime getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDateTime fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public BigDecimal getPrima() {
        return prima;
    }

    public void setPrima(BigDecimal prima) {
        this.prima = prima;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
