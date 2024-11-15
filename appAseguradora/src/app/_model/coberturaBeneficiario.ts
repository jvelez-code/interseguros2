import { Cobertura } from "./cobertura";

export class CoberturaBeneficiario {
  idBeneficiario: number;
  cobertura: Cobertura;  // Relación con Cobertura
  nombreBeneficiario: string;
  apellidoBeneficiario: string;
  documentoBeneficiario: string;
  relacionBeneficiario: string;

  constructor(
    idBeneficiario: number,
    cobertura: Cobertura,
    nombreBeneficiario: string,
    apellidoBeneficiario: string,
    documentoBeneficiario: string,
    relacionBeneficiario: string
  ) {
    this.idBeneficiario = idBeneficiario;
    this.cobertura = cobertura;
    this.nombreBeneficiario = nombreBeneficiario;
    this.apellidoBeneficiario = apellidoBeneficiario;
    this.documentoBeneficiario = documentoBeneficiario;
    this.relacionBeneficiario = relacionBeneficiario;
  }
}

let coberturaBeneficiario: CoberturaBeneficiario;
