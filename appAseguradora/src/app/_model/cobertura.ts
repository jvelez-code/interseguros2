export class Cobertura {
    idCobertura: number;
    nombreCobertura: string;
    descripcion: string;
  
    constructor(idCobertura: number, nombreCobertura: string, descripcion: string) {
      this.idCobertura = idCobertura;
      this.nombreCobertura = nombreCobertura;
      this.descripcion = descripcion;
    }
  }

  let cobertura: Cobertura;