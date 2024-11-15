package com.interseguros.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

@Entity
@Table(name = "tipos_seguros")
public class TipoSeguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipoSeguro", nullable = false)
    private Long idTipoSeguro;

    @Column(name = "tipo_seguro", nullable = false)
    private String tipoSeguro;

    public TipoSeguro() {
    }

    public TipoSeguro(String tipoSeguro, Long idTipoSeguro) {
        this.tipoSeguro = tipoSeguro;
        this.idTipoSeguro = idTipoSeguro;
    }

    public Long getIdTipoSeguro() {
        return idTipoSeguro;
    }

    public void setIdTipoSeguro(Long idTipoSeguro) {
        this.idTipoSeguro = idTipoSeguro;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }
}
