import { Cliente } from "./cliente";
import { CoberturaBeneficiario } from "./coberturaBeneficiario";
import { SubtipoSeguro } from "./subtipoSeguro";

export class DatosPoliza {
  codPoliza: number;
  cliente: Cliente;  // Relación con Cliente
  subtipoSeguro: SubtipoSeguro;  // Relación con SubtipoSeguro
  fechaInicial: string;  // Usamos string para la fecha en formato "yyyy-MM-dd HH:mm:ss"
  fechaFinal: string;
  montoAsegurado: number;
  prima: number;
  exclusiones: string;
  duracionMeses: string;
  condicionesReclamacion: string;
  estado: string;
  // Puede incluir un array de beneficiarios si es necesario
  beneficiarios: CoberturaBeneficiario[];

  constructor(
    codPoliza: number,
    cliente: Cliente,
    subtipoSeguro: SubtipoSeguro,
    fechaInicial: string,
    fechaFinal: string,
    montoAsegurado: number,
    prima: number,
    exclusiones: string,
    duracionMeses: string,
    condicionesReclamacion: string,
    estado: string,
    beneficiarios: CoberturaBeneficiario[] = []
  ) {
    this.codPoliza = codPoliza;
    this.cliente = cliente;
    this.subtipoSeguro = subtipoSeguro;
    this.fechaInicial = fechaInicial;
    this.fechaFinal = fechaFinal;
    this.montoAsegurado = montoAsegurado;
    this.prima = prima;
    this.exclusiones = exclusiones;
    this.duracionMeses = duracionMeses;
    this.condicionesReclamacion = condicionesReclamacion;
    this.estado = estado;
    this.beneficiarios = beneficiarios;
  }
}

let datosPoliza: DatosPoliza;