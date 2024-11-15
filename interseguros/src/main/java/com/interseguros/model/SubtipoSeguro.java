package com.interseguros.model;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "subtipos_seguros")
public class SubtipoSeguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subtiposeguro", nullable = false)
    private Long idSubtipoSeguro;

    @ManyToOne
    @JoinColumn(name = "tipo_seguro", nullable = false, foreignKey =  @ForeignKey(name = "fk_subtipo_tipo"))
    private TipoSeguro tipoSeguro;

    @Column(name = "subtipo_seguro", nullable = false)
    private String subtipoSeguro;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    
    @Column(name = "valor_seguro", nullable = false, precision = 8, scale = 2)
    private BigDecimal valorSeguro;

    public SubtipoSeguro() {
    }


    public SubtipoSeguro(Long idSubtipoSeguro, TipoSeguro tipoSeguro, String subtipoSeguro, String descripcion,
			BigDecimal valorSeguro) {
		super();
		this.idSubtipoSeguro = idSubtipoSeguro;
		this.tipoSeguro = tipoSeguro;
		this.subtipoSeguro = subtipoSeguro;
		this.descripcion = descripcion;
		this.valorSeguro = valorSeguro;
	}


	public Long getIdSubtipoSeguro() {
        return idSubtipoSeguro;
    }

    public void setIdSubtipoSeguro(Long idSubtipoSeguro) {
        this.idSubtipoSeguro = idSubtipoSeguro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSubtipoSeguro() {
        return subtipoSeguro;
    }

    public void setSubtipoSeguro(String subtipoSeguro) {
        this.subtipoSeguro = subtipoSeguro;
    }

    public TipoSeguro getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(TipoSeguro tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

	public BigDecimal getValorSeguro() {
		return valorSeguro;
	}

	public void setValorSeguro(BigDecimal valorSeguro) {
		this.valorSeguro = valorSeguro;
	}
    
    
}
