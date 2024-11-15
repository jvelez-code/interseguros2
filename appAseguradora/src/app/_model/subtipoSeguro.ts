import { TipoSeguro } from "./tipoSeguro";


export class SubtipoSeguro {
  idSubtipoSeguro: number;  // ID del subtipo de seguro
  tipoSeguro: TipoSeguro;   // Relación con el TipoSeguro
  subtipoSeguro: string;    // Nombre del subtipo de seguro
  descripcion: string;      // Descripción del subtipo de seguro
  valorSeguro: number;      // Valor del seguro (usamos 'number' para manejarlo como decimal)

  constructor(
    idSubtipoSeguro: number,
    tipoSeguro: TipoSeguro,
    subtipoSeguro: string,
    descripcion: string,
    valorSeguro: number
  ) {
    this.idSubtipoSeguro = idSubtipoSeguro;
    this.tipoSeguro = tipoSeguro;
    this.subtipoSeguro = subtipoSeguro;
    this.descripcion = descripcion;
    this.valorSeguro = valorSeguro;
  }
}

let subtipoSeguro: SubtipoSeguro;