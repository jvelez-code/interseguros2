package com.interseguros.model;

import jakarta.persistence.*;


@Entity
@Table(name = "cobertura_beneficiario")
public class CoberturaBeneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_beneficiario", nullable = false)
    private Long idBeneficiario;

    @ManyToOne
    @JoinColumn(name = "id_cobertura", nullable = false, foreignKey = @ForeignKey(name = "fk_beneficiario_columna"))
    private Cobertura cobertura; 

    @Column(name = "nombre_beneficiario", nullable = false)
    private String nombreBeneficiario;
    
    @Column(name = "documento_beneficiario", nullable = false)
    private String documentoBeneficiario;

    @Column(name = "relacion_beneficiario", nullable = false)
    private String relacionBeneficiario;

    public CoberturaBeneficiario() {
    }

    public CoberturaBeneficiario(Long idBeneficiario, String relacionBeneficiario, String documentoBeneficiario, String apellidoBeneficiario, String nombreBeneficiario, Cobertura cobertura) {
        this.idBeneficiario = idBeneficiario;
        this.relacionBeneficiario = relacionBeneficiario;
        this.documentoBeneficiario = documentoBeneficiario;
        this.nombreBeneficiario = nombreBeneficiario;
        this.cobertura = cobertura;
    }

    public Long getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(Long idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public String getRelacionBeneficiario() {
        return relacionBeneficiario;
    }

    public void setRelacionBeneficiario(String relacionBeneficiario) {
        this.relacionBeneficiario = relacionBeneficiario;
    }

    public String getDocumentoBeneficiario() {
        return documentoBeneficiario;
    }

    public void setDocumentoBeneficiario(String documentoBeneficiario) {
        this.documentoBeneficiario = documentoBeneficiario;
    }

    public String getNombreBeneficiario() {
        return nombreBeneficiario;
    }

    public void setNombreBeneficiario(String nombreBeneficiario) {
        this.nombreBeneficiario = nombreBeneficiario;
    }

    public Cobertura getCobertura() {
        return cobertura;
    }

    public void setCobertura(Cobertura cobertura) {
        this.cobertura = cobertura;
    }
}
