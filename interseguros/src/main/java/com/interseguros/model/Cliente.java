package com.interseguros.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @Column(name = "cedula_cliente")
    private Integer cedulaCliente;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "correo_cliente")
    private String correoCliente;

    @Column(name = "nro_celular")
    private String nroCelular;

    @ManyToOne
    @JoinColumn(name = "cod_ubicacion", nullable = false, foreignKey = @ForeignKey(name = "fk_cliente_ubicacion"))
    private Ubicacion ubicacion;

    public Cliente() {
    }

    public Cliente(Integer cedulaCliente, Ubicacion ubicacion, String nroCelular, String correoCliente, String tipoDocumento) {
        this.cedulaCliente = cedulaCliente;
        this.ubicacion = ubicacion;
        this.nroCelular = nroCelular;
        this.correoCliente = correoCliente;
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(Integer cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNroCelular() {
        return nroCelular;
    }

    public void setNroCelular(String nroCelular) {
        this.nroCelular = nroCelular;
    }
}


