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

    @Column(name = "monto_asegurado", nullable = false)
    private BigDecimal montoAsegurado;

    @Column(name = "prima", nullable = false)
    private BigDecimal prima;

    @Column(name = "exclusiones", nullable = false)
    private String exclusiones;

    @Column(name = "duracion_meses", nullable = false)
    private String duracionMeses;

    @Column(name = "condiciones_reclamacion", nullable = false)
    private String condicionesReclamacion;

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
        this.montoAsegurado = montoAsegurado;
        this.prima = prima;
        this.exclusiones = exclusiones;
        this.duracionMeses = duracionMeses;
        this.condicionesReclamacion = condicionesReclamacion;
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

    public BigDecimal getMontoAsegurado() {
        return montoAsegurado;
    }

    public void setMontoAsegurado(BigDecimal montoAsegurado) {
        this.montoAsegurado = montoAsegurado;
    }

    public BigDecimal getPrima() {
        return prima;
    }

    public void setPrima(BigDecimal prima) {
        this.prima = prima;
    }

    public String getExclusiones() {
        return exclusiones;
    }

    public void setExclusiones(String exclusiones) {
        this.exclusiones = exclusiones;
    }

    public String getDuracionMeses() {
        return duracionMeses;
    }

    public void setDuracionMeses(String duracionMeses) {
        this.duracionMeses = duracionMeses;
    }

    public String getCondicionesReclamacion() {
        return condicionesReclamacion;
    }

    public void setCondicionesReclamacion(String condicionesReclamacion) {
        this.condicionesReclamacion = condicionesReclamacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
